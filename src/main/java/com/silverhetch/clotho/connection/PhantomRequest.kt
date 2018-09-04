package com.silverhetch.clotho.connection

/**
 * Phantom request that always return 200.
 */
class PhantomRequest() : WebRequest {
    override fun url(): String {
        return "phantom://phantom.host"
    }

    override fun request(): Response {
        with(Response()) {
            code = 200
            bodyBytes = "".toByteArray()
            return this
        }
    }
}