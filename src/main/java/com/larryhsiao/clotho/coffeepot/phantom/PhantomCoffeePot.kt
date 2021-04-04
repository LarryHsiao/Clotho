package com.larryhsiao.clotho.utility.coffeepot.phantom

import com.larryhsiao.clotho.observable.Observable
import com.larryhsiao.clotho.observable.ObservableImpl
import com.larryhsiao.clotho.utility.coffeepot.Bean
import com.larryhsiao.clotho.utility.coffeepot.CoffeePot
import com.larryhsiao.clotho.utility.coffeepot.Cup
import java.util.*
import kotlin.concurrent.timerTask

/**
 * Coffee pot in the phantom. Not real thing
 */
class PhantomCoffeePot(private val parameters: Parameters = PhantomParameters()) : CoffeePot {
    private var light = ObservableImpl<Boolean>(false)
    private var brewing = ObservableImpl<Boolean>(false)

    override fun brew(bean: Bean) {
        if (brewing.value() || light.value()) {
            return
        }
        brewing.notifyObservers(true)
        val brewUnit = Timer()
        brewUnit.schedule(timerTask {
            brewing.notifyObservers(false)
            light.notifyObservers(true)
        }, parameters.duration())
    }

    override fun fill(cup: Cup) {
        if (brewing.value() || !light.value()) {
            return
        }
        light.notifyObservers(false)
        cup.pour(PhantomCoffee())
    }

    override fun light(): Observable<Boolean> {
        return light
    }

    override fun brewing(): Observable<Boolean> {
        return brewing
    }
}