package com.silverhetch.clotho.utility

interface Platform {
    fun name(): String

    override fun equals(other: Any?): Boolean

}