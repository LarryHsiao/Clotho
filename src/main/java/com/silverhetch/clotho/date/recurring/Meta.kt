package com.silverhetch.clotho.date.recurring

interface Meta {
    fun start():Long
    fun interval():Long
    fun year():Int
    fun month():Int
    fun day():Int
    fun week():Int
    fun weekday():Int
}