package com.silverhetch.clotho.connection;

import com.silverhetch.clotho.connection.exception.HttpException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Template class for quick implement http request.
 * Implement {@link WebApi#setupConnection(HttpURLConnection)} for header, request body, etc.
 * <p>
 * All failed returns {@link Response} Object.Including exception cause with code -1.
 * Created by Larry Hsiao on 2016/11/16.
 */
public abstract class WebApi implements WebRequest {
    private final Target target;

    public WebApi(Target target) {
        this.target = target;
    }

    protected abstract void setupConnection(HttpURLConnection connection) throws Exception;

    @Override
    public String url() {
        return target.url();
    }

    @Override
    public final Response request() throws HttpException {
        try {
            URL url = new URL(this.target.url());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            setupSSL(connection);
            setupConnection(connection);
            int responseCode = connection.getResponseCode();
            return handleResponse(responseCode, connection);
        } catch (Exception ex) {
            throw new HttpException(ex);
        }
    }

    private void setupSSL(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection && target.socketFactory() != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(target.socketFactory());
        }
    }

    private Response handleResponse(int responseCode, HttpURLConnection urlConnection) throws Exception {
        if (responseCode >= 200 && responseCode < 300) {
            return handleResponse(responseCode, urlConnection.getInputStream());
        } else {
            return handleResponse(responseCode, urlConnection.getErrorStream());
        }
    }

    private Response handleResponse(int responseCode, InputStream responseStream) throws Exception {
        try (DataInputStream wrappedStream = new DataInputStream(responseStream)) {
            byte[] responseBytes = convertInputStreamToByteArray(wrappedStream);
            Response responseObject = new Response();
            responseObject.code = responseCode;
            responseObject.bodyBytes = responseBytes;
            return responseObject;
        }
    }

    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws Exception {
        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            channelStream(inputStream, result);
            return result.toByteArray();
        }
    }

    private void channelStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
    }
}
