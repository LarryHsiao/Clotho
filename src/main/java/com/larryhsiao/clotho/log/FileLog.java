//package com.larryhsiao.clotho.log;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Log to file.
// */
//public class FileLog {
//    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
//    private static final String MSG_FORMAT = "%s: %s - %s";  // timestamp, tag, message
//
//    private static String sLogFilePath;
//    private static File sTheLogFile;
//    private static BufferedWriter sBufferedWriter;
//    private static int sCurrentPriority;
//    private static int sFileSizeLimit;                  // bytes
//
//    private final Log log;
//
//    public FileLog(Log log) {this.log = log;}
//
//    public void open(String logFilePath, int currentPriority, int fileSizeLimit) {
//        sLogFilePath = logFilePath;
//        sCurrentPriority = currentPriority;
//        sFileSizeLimit = fileSizeLimit;
//
//        sTheLogFile = new File(sLogFilePath);
//        if (!sTheLogFile.exists()) {
//            try {
//                sTheLogFile.createNewFile();
//            } catch (IOException e) {
//                Log.e("FileLog", Log.getStackTraceString(e));
//            }
//        }
//
//        checkFileSize();
//
//        try {
//            sBufferedWriter = new BufferedWriter(new FileWriter(sTheLogFile, true));
//        } catch (IOException e) {
//            log.error(e.fillInStackTrace());
//        }
//    }
//
//    public static void setCurrentPriority(int currentPriority) {
//        sCurrentPriority = currentPriority;
//    }
//
//    public static void close() {
//        try {
//            if (sBufferedWriter != null) {
//                sBufferedWriter.newLine();
//                sBufferedWriter.flush();
//                sBufferedWriter.close();
//            }
//        } catch (IOException e) {
//            Log.e("FileLog", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void delete() {
//        close();
//
//        if (sTheLogFile != null) {
//            sTheLogFile.delete();
//        }
//    }
//
//    public static int v(String tag, String msg) {
//        writeToFile(Log.VERBOSE, tag, msg);
//
//        return Log.v(tag, msg);
//    }
//
//    public static int v(String tag, String msg, Throwable tr) {
//        writeToFile(Log.VERBOSE, tag, msg, tr);
//
//        return Log.v(tag, msg, tr);
//    }
//
//    public static int d(String tag, String msg) {
//        writeToFile(Log.DEBUG, tag, msg);
//
//        return Log.d(tag, msg);
//    }
//
//    public static int d(String tag, String msg, Throwable tr) {
//        writeToFile(Log.DEBUG, tag, msg, tr);
//
//        return Log.d(tag, msg, tr);
//    }
//
//    public static int i(String tag, String msg) {
//        writeToFile(Log.INFO, tag, msg);
//
//        return Log.i(tag, msg);
//    }
//
//    public static int i(String tag, String msg, Throwable tr) {
//        writeToFile(Log.INFO, tag, msg, tr);
//
//        return Log.i(tag, msg, tr);
//    }
//
//    public static int w(String tag, String msg) {
//        writeToFile(Log.WARN, tag, msg);
//
//        return Log.w(tag, msg);
//    }
//
//    public static int w(String tag, String msg, Throwable tr) {
//        writeToFile(Log.WARN, tag, msg, tr);
//
//        return Log.w(tag, msg, tr);
//    }
//
//    public static int w(String tag, Throwable tr) {
//        writeToFile(Log.WARN, tag, "", tr);
//
//        return Log.w(tag, tr);
//    }
//
//    public static int e(String tag, String msg) {
//        writeToFile(Log.ERROR, tag, msg);
//
//        return Log.e(tag, msg);
//    }
//
//    public static int e(String tag, String msg, Throwable tr) {
//        writeToFile(Log.ERROR, tag, msg, tr);
//
//        return Log.e(tag, msg, tr);
//    }
//
//    public static String getStackTraceString(Throwable tr) {
//        return Log.getStackTraceString(tr);
//    }
//
//    private static void writeToFile(int priority, String tag, String msg) {
//        writeToFile(priority, tag, msg, null);
//    }
//
//    private static void writeToFile(int priority, String tag, String msg, Throwable tr) {
//        if ((priority >= sCurrentPriority) &&
//            (sBufferedWriter != null)) {
//            try {
//                if (checkFileSize()) {
//                    sBufferedWriter = new BufferedWriter(new FileWriter(sTheLogFile, true));
//                }
//
//                sBufferedWriter.write(formatMsg(tag, msg));
//                sBufferedWriter.newLine();
//
//                if (tr != null) {
//                    sBufferedWriter.write(Log.getStackTraceString(tr));
//                    sBufferedWriter.newLine();
//                }
//
//                sBufferedWriter.flush();
//            } catch (IOException e) {
//                Log.e("FileLog", Log.getStackTraceString(e));
//            }
//        }
//
//        if (sBufferedWriter == null) {
//            Log.e("FileLog", "You have to call FileLog.open(...) before starting to log");
//        }
//    }
//
//    private static String formatMsg(String tag, String msg) {
//        return String.format(MSG_FORMAT, getCurrentTimeStamp(), tag, msg);
//    }
//
//    private static String getCurrentTimeStamp() {
//        String currentTimeStamp = null;
//
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT,
//                java.util.Locale.getDefault());
//            currentTimeStamp = dateFormat.format(new Date());
//        } catch (Exception e) {
//            Log.e("FileLog", Log.getStackTraceString(e));
//        }
//
//        return currentTimeStamp;
//    }
//
//    private static boolean checkFileSize() {
//        boolean createdNewLogFile = false;
//        try {
//            if (sTheLogFile.length() > sFileSizeLimit) {
//                File to = new File(sLogFilePath + ".old");
//                if (to.exists()) {
//                    to.delete();
//                }
//
//                sTheLogFile.renameTo(to);
//
//                sTheLogFile = new File(sLogFilePath);
//                sTheLogFile.createNewFile();
//
//                createdNewLogFile = true;
//            }
//        } catch (IOException e) {
//            Log.e("FileLog", Log.getStackTraceString(e));
//        }
//
//        return createdNewLogFile;
//    }
//}
