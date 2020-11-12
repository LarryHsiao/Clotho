package com.larryhsiao.clotho.utility.coffeepot.phantom

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.CountDownLatch

class PhantomCoffeePotTest {
    @Test
    fun simple() {
        val countDownLatch = CountDownLatch(1)
        PhantomCoffeePot(
            PhantomParameters(1)
        ).let {
            it.light().addObserver { _, _ -> countDownLatch.countDown() }
            it.brew(PhantomBean())
            countDownLatch.await()
            assertEquals(0, countDownLatch.count)
        }
    }
}