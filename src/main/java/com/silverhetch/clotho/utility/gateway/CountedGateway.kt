package com.silverhetch.clotho.utility.gateway

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.storage.Ceres

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