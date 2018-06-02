package com.silverhetch.clotho.log;

/**
 * Created by Larry Hsiao on 2017/6/18.
 */

public interface Log {
    void info(String message);

    void debug(String message);

    void warning(String message);

    void error(String message);
}
