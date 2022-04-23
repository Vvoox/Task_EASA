package com.easa.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @autho KHALIL DAOULAT
 */
public class ReadFile {

    // Read an input and return text String
    public static String readFile(String filePath, Charset utf8) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath), utf8);
        return String.join(System.lineSeparator(), lines);
    }
}
