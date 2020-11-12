package com.larryhsiao.clotho.utility.coffeepot.phantom

import com.larryhsiao.clotho.utility.coffeepot.Coffee

/**
 * The phantom of coffee
 */
class PhantomCoffee(private val content: String = "Black") : Coffee {
    override fun content(): String {
        return "$content coffee"
    }
}