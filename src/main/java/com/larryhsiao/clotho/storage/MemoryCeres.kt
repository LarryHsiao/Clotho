package com.larryhsiao.clotho.storage

/**
 * Ceres implementation
 */
class MemoryCeres : Ceres {
    private val map = HashMap<String, String>()
    override fun store(key: String, value: String) {
        map[key] = value
    }

    override fun get(key: String): String {
        return map[key] ?: ""
    }

    override fun all(): Map<String, String> {
        return map
    }

    override fun delete(key: String) {
        map.remove(key)
    }
}