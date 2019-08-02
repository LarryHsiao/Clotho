package com.silverhetch.clotho

import com.silverhetch.clotho.connection.*
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test
import java.net.HttpURLConnection.HTTP_OK

/**
 * Created by Larry Hsiao on 2016/11/20.
 */
class WebRequestTest {
    @Test
    fun getUrl() {
        val api = Get(TargetImpl("https://google.com"))
        val response = api.request()
        assertEquals(HTTP_OK.toLong(), response.code.toLong())
    }

    @Test
    fun getNotExistUrl() {
        try {
            val api = Get(TargetImpl("Https://google.comfd"))
            api.request()
            fail()
        } catch (e: Exception) {
            assertTrue(true)
        }

    }

    @Test
    fun getUnknownProtocol() {
        try {
            Get(TargetImpl("telnet://google.com")).request()
            fail()
        } catch (e: Exception) {
            assertTrue(true)
        }

    }

    @Test
    fun getNonUriSchema() {
        try {
            Get(TargetImpl("https://:::")).request()
            fail()
        } catch (e: Exception) {
            assertTrue(true)
        }

    }

    @Test
    fun methodSpec() {
        val method = WebRequest::class.java.getMethod("request")
        assertEquals(0, method.exceptionTypes.size.toLong())
    }

    /**
     * Check result is the same with header.
     *
     * @todo #1 test the sending header is the same as input
     */
    @Test
    fun withHeader() {
        val api = Get(TargetImpl("https://google.com"),
            object : Headers {
                override fun values(): Map<String, String> {
                    return hashMapOf(
                        Pair("key", "value")
                    )
                }
            })
        val response = api.request()
        assertEquals(HTTP_OK.toLong(), response.code.toLong())
    }
}