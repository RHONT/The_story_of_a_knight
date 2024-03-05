package com.rhontproject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.lang.System.*;

/**
 * Распечатывает в консоль историю.
 * /stories/ - источник
 * Открываю файлы как ресурс. Чтобы при упаковке в jar они были добавлены.
 */
public final class SystemUtility {
    private SystemUtility() {
    }
    public static void printFromFile(String str) {
        try (InputStream inputStream = SystemUtility.class.getResourceAsStream("/stories/" + str);
        ) {
            if (inputStream != null) {
                try (Scanner scanForPrintInConsole = new Scanner(inputStream,"Windows-1251");
                ) {
                    while (scanForPrintInConsole.hasNext()) {
                        out.println(scanForPrintInConsole.nextLine());
                    }
                    out.println("\nНажмите Enter для продолжения");
                }
            } else {
                out.println("Часть истории не найдена");
            }
        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }
}
