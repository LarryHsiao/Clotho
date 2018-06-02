package com.silverhetch.clotho.connection;

/**
 * Created by Larry Hsiao on 2016/11/2.
 */

public interface WebRequest {
    String url();

    Response request();
}
