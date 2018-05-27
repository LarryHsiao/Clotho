package com.silverhetch.elizabeth.arch

interface KeyValues {
    fun save(key: String, value: String)
    fun value(key: String): String
}