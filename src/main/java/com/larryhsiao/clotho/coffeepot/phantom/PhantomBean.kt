package com.larryhsiao.clotho.utility.coffeepot.phantom

import com.larryhsiao.clotho.utility.coffeepot.Bean

/**
 * Phantom of Coffee bean.
 */
class PhantomBean : Bean {
    override fun content(): String {
        return "American"
    }
}