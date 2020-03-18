package com.wordApp.App;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class WordProcessor {
public static String read(BufferedReader bf) throws IOException {
        StringBuilder sb = new StringBuilder();
        String nextLine;
        do{
            nextLine = bf.readLine();
            sb.append(nextLine);
        }while(nextLine != null);
        return  sb.toString();
    }
}
