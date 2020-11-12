package com.larryhsiao.clotho.utility.coffeepot

import com.larryhsiao.clotho.observable.Observable

/**
 * Class represent a coffee pot.
 */
interface CoffeePot {
    /**
     * Brew the coffee, may takes some time
     */
    fun brew(bean: Bean)

    /**
     * Fill the given cup with coffee
     */
    fun fill(cup: Cup)

    /**
     * @return true if there are brewed coffee in the [CoffeePot], otherwise false
     */
    fun light(): Observable<Boolean>

    /**
     * @return true if [CoffeePot] is brewing coffee.
     */
    fun brewing(): Observable<Boolean>
}