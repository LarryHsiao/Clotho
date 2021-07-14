package com.larryhsiao.clotho.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Log to file.
 */
public class FileLog implements Log {
    private final Log fallbackLog;
    private final String filePath;
    private final int fileLimit;
    private File logFile;
    private BufferedWriter bufferWriter;

    public FileLog(String filePath) {
        this(new SystemPrintLog(), filePath, 1024 * 1024 * 10); // 10 MB
    }

    public FileLog(Log fallbackLog, String logFilePath, int fileSizeLimit) {
        this.fallbackLog = fallbackLog;
        filePath = logFilePath;
        fileLimit = fileSizeLimit;
    }

    public void open(){
        logFile = new File(filePath);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                fallbackLog.error(new ExceptionString(e).value());
            }
        }
        checkFileSize();
        try {
            bufferWriter = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException e) {
            fallbackLog.error(new ExceptionString(e).value());
        }
    }

    public void close() {
        try {
            if (bufferWriter != null) {
                bufferWriter.flush();
                bufferWriter.close();
            }else {
                throw new IOException("file not opened with bufferWriter");
            }
        } catch (IOException e) {
            fallbackLog.error(new ExceptionString(e).value());
        }
    }

    @Override
    public void info(String message) {
        writeToFile(message);
    }

    @Override
    public void debug(String message) {
        writeToFile(message);
    }

    @Override
    public void warning(String message) {
        writeToFile(message);
    }

    @Override
    public void error(String message) {
        writeToFile(message);
    }

    private void writeToFile(String msg) {
        if (bufferWriter == null || !logFile.exists()) {
            fallbackLog.error("You have to call FileLog.open(...) before starting to log");
        } else {
            try {
                if (checkFileSize()) {
                    bufferWriter = new BufferedWriter(new FileWriter(logFile, true));
                }
                bufferWriter.write(msg);
                bufferWriter.newLine();
                bufferWriter.flush();
            } catch (IOException e) {
                fallbackLog.error(new ExceptionString(e).value());
            }
        }
    }

    private boolean checkFileSize() {
        boolean createdNewLogFile = false;
        try {
            if (logFile.length() > fileLimit) {
                File to = new File(filePath + System.currentTimeMillis());
                logFile.renameTo(to);
                logFile = new File(filePath);
                logFile.createNewFile();
                createdNewLogFile = true;
            }
        } catch (IOException e) {
            fallbackLog.error(new ExceptionString(e).value());
        }
        return createdNewLogFile;
    }
}
