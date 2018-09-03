package com.silverhetch.clotho.connection;

/**
 * Represent a web request.
 */

public interface WebRequest {
    /**
     * Url of the target
     */
    String url();

    /**
     * Request to WebAPI.
     * @return API response
     */
    Response request();
}
