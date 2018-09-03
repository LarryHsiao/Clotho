package com.silverhetch.clotho.connection;

import javax.net.ssl.SSLSocketFactory;

/**
 * Request target.
 */
public interface Target {
    /**
     * Target url.
     */
    String url();

    /**
     * SocketFactory builder for secure connection.
     */
    SSLSocketFactory socketFactory();
}
