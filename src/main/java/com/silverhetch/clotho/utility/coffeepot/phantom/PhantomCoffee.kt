package com.silverhetch.elizabeth.coffeepot.phantom

import com.silverhetch.elizabeth.coffeepot.Coffee

/**
 * The phantom of coffee
 */
class PhantomCoffee(private val content: String = "Black") : Coffee {
    override fun content(): String {
        return "$content coffee"
    }
}