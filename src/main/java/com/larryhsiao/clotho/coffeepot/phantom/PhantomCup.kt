package com.larryhsiao.clotho.utility.coffeepot.phantom

import com.larryhsiao.clotho.utility.coffeepot.Coffee
import com.larryhsiao.clotho.utility.coffeepot.Cup

/**
 * Phantom object of cup which has [PhantomCoffee] in it.
 */
class PhantomCup : Cup {
    private var coffee: Coffee = PhantomCoffee()
    override fun pour(coffee: Coffee) {
        this.coffee = coffee
    }

    override fun content(): Coffee {
        return coffee
    }
}