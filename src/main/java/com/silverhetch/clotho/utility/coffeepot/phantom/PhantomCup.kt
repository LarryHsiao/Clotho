package com.silverhetch.elizabeth.coffeepot.phantom

import com.silverhetch.elizabeth.coffeepot.Coffee
import com.silverhetch.elizabeth.coffeepot.Cup

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