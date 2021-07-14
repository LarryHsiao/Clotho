package com.larryhsiao.clotho.log;

import com.larryhsiao.clotho.Source;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * String trace string from exception.
 */
public class ExceptionString implements Source<String> {
    private final Exception exception;

    public ExceptionString(Exception exception) {this.exception = exception;}

    @Override
    public String value() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw.toString();
    }
}
