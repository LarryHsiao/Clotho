package com.silverhetch.clotho.date.recurring

import java.util.*

interface Recurring {
    fun byTheEndOf(endDate: Calendar): List<Calendar>
}