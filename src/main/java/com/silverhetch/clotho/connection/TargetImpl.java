package com.silverhetch.clotho.connection;

import javax.net.ssl.SSLSocketFactory;

public class TargetImpl implements Target {
    private final String url;
    private final SSLSocketFactory sslSocketFactory;

    public TargetImpl(String url, SSLSocketFactory sslSocketFactory) {
        this.url = url;
        this.sslSocketFactory = sslSocketFactory;
    }

    public TargetImpl(String url){
        this(url, null);
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public SSLSocketFactory socketFactory() {
        return sslSocketFactory;
    }
}
