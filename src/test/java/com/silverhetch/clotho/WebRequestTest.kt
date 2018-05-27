package com.silverhetch.clotho

import com.silverhetch.clotho.connection.*
import com.silverhetch.elizabeth.arch.connection.Get
import org.junit.Ignore
import org.junit.Test

import java.lang.reflect.Method

import java.net.HttpURLConnection.HTTP_OK
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail

/**
 * Created by Larry Hsiao on 2016/11/20.
 */
class WebRequestTest {

    @Ignore("Actual request")
    @Test
    fun getUrl() {
        val api = Get(TargetImpl("https://google.com"))
        val response = api.request()
        assertEquals(HTTP_OK.toLong(), response.code.toLong())
    }

    @Ignore("Actual request")
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
}