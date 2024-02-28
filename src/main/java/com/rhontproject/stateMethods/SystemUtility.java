package com.rhontproject.stateMethods;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.lang.System.*;

public class SystemUtility {
    public static void printFromFile(String str) {
        try (InputStream inputStream = SystemUtility.class.getResourceAsStream("/stories/" + str);
        ) {
            if (inputStream != null) {
                try (Scanner scan_for_read = new Scanner(inputStream,"Windows-1251");
                ) {
                    while (scan_for_read.hasNext()) {
                        out.println(scan_for_read.nextLine());
                    }
                }
            } else {
                out.println("Часть истории не найдена");
            }
        } catch (IOException ignored) {
        }
    }
}
