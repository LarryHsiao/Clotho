package com.silverhetch.clotho

interface KeyValues {
    fun save(key: String, value: String)
    fun value(key: String): String
}