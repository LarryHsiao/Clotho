package com.silverhetch.clotho.date.recurring

import org.junit.Assert
import org.junit.Test
import java.util.*

class MetaRecurringTest {
    @Test
    fun allDays() {
        MetaRecurring(
            ConstMeta(
                System.currentTimeMillis(),
                0L,
                0, 0, 0, 0, 0
            )
        ).byTheEndOf(Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, 29) }).run {
            Assert.assertEquals(
                30,
                size
            )
        }

    }

    @Test
    fun fistDayOfSecondWeekOfMonth() {
        MetaRecurring(
            ConstMeta(
                System.currentTimeMillis(),
                0L,
                0, 0, 0, 2, 1
            )
        ).byTheEndOf(Calendar.getInstance().apply { add(Calendar.YEAR, 1) }).run {
            Assert.assertEquals(
                12,
                size
            )
        }
    }


    @Test
    fun interval() {
        MetaRecurring(
            ConstMeta(
                System.currentTimeMillis(),
                86400000,
                0,
                0,
                0,
                0,
                0
            )
        ).byTheEndOf(Calendar.getInstance().apply { add(Calendar.YEAR, 1) }).run {
            Assert.assertEquals(
                367,
                size
            )
        }
    }
}