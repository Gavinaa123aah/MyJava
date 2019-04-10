package com.cainiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyIO {
    /**
     * read string from console
     * @throws IOException
     */
    static void read_string() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        do {
            s=bufferedReader.readLine();
            System.out.println(s);
        }while (!s.equals("exit"));

    }
    static void read_char() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char s;
        do {
            s=(char)bufferedReader.read();
            System.out.println(s);
        }while (s!='q');
    }

    /**
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
     read_char();

    }
}
