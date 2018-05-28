package com.silverhetch.elizabeth

interface KeyValues {
    fun save(key: String, value: String)
    fun value(key: String): String
}