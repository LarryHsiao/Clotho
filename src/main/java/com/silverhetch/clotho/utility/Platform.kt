package com.silverhetch.elizabeth.arch.utility

interface Platform {
    fun name():String

    override fun equals(other: Any?): Boolean

}