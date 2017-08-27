package com.silverhetch.clotho.connection;

import javax.net.ssl.SSLSocketFactory;

public interface Target {
    String url();
    SSLSocketFactory socketFactory();
}
