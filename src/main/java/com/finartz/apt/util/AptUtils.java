package com.finartz.apt.util;

import java.io.IOException;
import java.io.Reader;

public class AptUtils {

    /**
     * @param reader
     * @return
     * @throws IOException
     */
    public static String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static boolean isStringNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
