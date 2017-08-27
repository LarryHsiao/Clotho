package com.silverhetch.clotho.connection;

import java.net.HttpURLConnection;

/**
 * Created by Larry Hsiao on 2016/11/20.
 */

public class Get extends WebApi {

    public Get(Target target){
        super(target);
    }
    @Override
    protected void setupConnection(HttpURLConnection connection) throws Exception {
    }
}
