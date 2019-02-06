package com.company;

import java.util.Scanner;

class FirstTask {
    protected String [] array;

    void showShortLongNumber() {
        String minStr = null;
        String maxStr = null;
        int minCol = 1000;
        int maxCol = 0;
        System.out.print("Введите числа: ");
        String input = new Scanner(System.in).nextLine();
        array = input.split("\\s+");
        for (String i : array) {
            if (i.length() < minCol) {
                minCol = i.length();
                minStr = i;
            }
            if (i.length() > maxCol) {
                maxCol = i.length();
                maxStr = i;
            }
        }
        if (minCol == maxCol) {
            System.out.printf("Все числа одной длины и состоят из %d цифр(-ы).\n", minCol);

        } else {
            System.out.printf("Минимальное число: %s состоит из %d цифр(-ы).\n", minStr, minCol);
            System.out.printf("Максимальное число: %s состоит из %d цифр.\n", maxStr, maxCol);
        }
    }
}

