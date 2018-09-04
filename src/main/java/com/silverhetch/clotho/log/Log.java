package com.silverhetch.clotho.log;

/**
 * Log definition
 */
public interface Log {
    /**
     * The general purpose log.
     */
    void info(String message);

    /**
     * Debug purpose log.
     */
    void debug(String message);

    /**
     * Warning purpose log.
     */
    void warning(String message);

    /**
     * Error purpose log.
     */
    void error(String message);
}
