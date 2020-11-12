package com.larryhsiao.clotho.utility.gateway

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.storage.Ceres

/**
 * A gate way that oi
 */
class CountedGateway(
    private val preferenceSource: Source<Ceres>,
    private val maxCount: Int,
    private val delegate: () -> Unit
) : Source<Unit> {
    override fun value() {
        val preference = preferenceSource.value()
        val curr = preference.get("count").let {
            if (it.isEmpty()) {
                0
            } else {
                it.toInt()
            }
        }
        if (maxCount <= curr) {
            delegate()
        } else {
            preference.store("count", (curr + 1).toString())
        }
    }
}