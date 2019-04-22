package com.silverhetch.clotho.date.recurring

class ConstMeta(
    private val start: Long,
    private val interval: Long,
    private val year: Int,
    private val month: Int,
    private val day: Int,
    private val week: Int,
    private val weekday: Int

) : Meta {
    override fun start(): Long {
        return start
    }

    override fun interval(): Long {
        return interval
    }

    override fun year(): Int {
        return year
    }

    override fun month(): Int {
        return month
    }

    override fun day(): Int {
        return day
    }

    override fun week(): Int {
        return week
    }

    override fun weekday(): Int {
        return weekday
    }
}