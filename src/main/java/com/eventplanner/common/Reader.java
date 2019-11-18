package com.eventplanner.common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final DataInputStream dataInput = new DataInputStream(System.in);

    public static String readLine() throws IOException {
        ArrayList<Character> charArray = new ArrayList<>(100);
        char c1;
        while (true) {
            c1 = (char) dataInput.readByte();
            if (c1 != '\n') {
                charArray.add(c1);
            } else {
                char[] array = new char[charArray.size()];
                for (int i = 0; i < charArray.size(); i++) {
                    array[i] = charArray.get(i);
                }
                return String.copyValueOf(array);
            }
        }
    }
}
