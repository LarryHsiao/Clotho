package com.silverhetch.clotho;

import com.silverhetch.clotho.connection.*;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Method;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Larry Hsiao on 2016/11/20.
 */
public class WebRequestTest {

    @Ignore("Actual request")
    @Test
    public void getUrl() throws Exception {
        Get api = new Get(new TargetImpl("https://google.com"));
        Response response = api.request();
        assertEquals(HTTP_OK, response.code);
    }

    @Ignore("Actual request")
    @Test
    public void getNotExistUrl() throws Exception {
        try {
            Get api = new Get(new TargetImpl("Https://google.comfd"));
            api.request();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getUnknownProtocol() throws Exception {
        try {
            new Get(new TargetImpl("telnet://google.com")).request();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getNonUriSchema() throws Exception {
        try {
            new Get(new TargetImpl("https://:::")).request();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void methodSpec() throws Exception {
        Method method = WebRequest.class.getMethod("request");
        assertEquals(0, method.getExceptionTypes().length);
    }
}