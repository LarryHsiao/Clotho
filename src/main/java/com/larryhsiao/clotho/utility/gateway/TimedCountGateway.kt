package com.larryhsiao.clotho.utility.gateway

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.storage.Ceres

/**
 * Gateway that given method will only triggered
 * if value() had triggered specific times in specific duration
 * or it had been triggered before.
 *
 * Implement one if other parameters required.
 */
class TimedCountGateway(
    private val preferenceSource: Source<Ceres>,
    private val method: () -> Unit
) : Source<Unit> {
    companion object {
        private const val COUNT_MAX = 10
        private const val DURATION_MAX_MILL = 10000
    }

    private var lastTimestamp: Long = 0
    private var count: Int = 0

    override fun value() {
        val preference = preferenceSource.value()
        if (preference.get("triggered").toBoolean()) {
            method()
        } else {
            val triggered = timeBaseTrigger()
            if (triggered) {
                preference.store("triggered", triggered.toString())
            }
        }
    }

    private fun timeBaseTrigger(): Boolean {
        var triggered = false
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastTimestamp > DURATION_MAX_MILL) {
            count = 0
        } else {
            count++
            if (count >= COUNT_MAX) {
                method()
                triggered = true
            }
        }
        lastTimestamp = currentTime
        return triggered
    }
}