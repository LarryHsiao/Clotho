package com.silverhetch.clotho.utility.coffeepot.phantom

import com.silverhetch.clotho.observable.Observable
import com.silverhetch.clotho.observable.ObservableImpl
import com.silverhetch.elizabeth.coffeepot.Bean
import com.silverhetch.elizabeth.coffeepot.CoffeePot
import com.silverhetch.elizabeth.coffeepot.Cup
import com.silverhetch.elizabeth.coffeepot.phantom.PhantomCoffee
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