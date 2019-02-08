package com.company;

import java.util.Scanner;

class FirstEighthTask {
    private String[] array;
    private String minStr = null;
    private String maxStr = null;
    private Scanner scan = new Scanner(System.in);
    String input;


    /*-- Ввести n чисел с консоли.----------------------------------------------------------
         1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.*/
//-----------Первый вариант------------------------------------------------------------
    void showShortLongNumber() {
        int minCol = 1000;
        int maxCol = 0;
        System.out.print("Введите числа: ");
        input = scan.nextLine();
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

//-----------Второй вариант-------------------------------------------------------
   /* void showShortLongNumber() {
        long number;
        int counter = 1;
        int minCol = 10;
        int maxCol = 0;
        long maxNum = 0;
        long minNum = 0;
        System.out.print("Введите числа: ");
        String s = new Scanner(System.in).nextLine();
        String[] array = s.split("\\s+");
        long[] arrayNum = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNum[i] = Long.parseLong(array[i]);
        }
        System.out.print("Длина введенных чисел: ");
        for (long i : arrayNum) {
            number = i / 10;
            while (number != 0) {
                counter++;
                number = number / 10;
            }
            System.out.print(counter + " ");
            if (counter < minCol) {
                minCol = counter;
                minNum = i;
            }
            if (counter > maxCol) {
                maxCol = counter;
                maxNum = i;
            }

            counter = 1;
        }
        if (minCol == maxCol) {
            System.out.printf("\nВсе числа одной длины и состоят из %d цифр(-ы).\n", minCol);

        } else {
            System.out.printf("\nМинимальное число: %d состоит из %d цифр(-ы).", minNum, minCol);
            System.out.printf("\nМаксимальное число: %d состоит из %d цифр.", maxNum, maxCol);
        }
    }*/

    //---2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.--------
    void sortNumbers() {
        System.out.print("Числа в порядке возрастания значений их длины: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].length() > array[j].length()) {
                    String tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        for (String element : array) {
            System.out.print(element + ", ");
        }

        System.out.print("\nЧисла в порядке убывания значений их длины: ");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].length() < array[j].length()) {
                    String tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        for (String element : array) {
            System.out.print(element + ", ");
        }
    }

    //---3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.---
    void showAverageLength() {
        int sum = 0;
        int average;
        int counter = 0;
        System.out.print("\nДлина введенных чисел: ");
        for (String i : array) {
            System.out.print(i.length() + "  ");
            sum += i.length();
        }
        average = sum / array.length;
        System.out.println("\nСредняя длина: " + average);
        System.out.println("Числа, длина которых меньше средней: ");
        for (String i : array) {
            if (i.length() < average) {
                System.out.println(i + " - его длина: " + i.length());
                counter = 1;
            }
        }
        if (counter == 0) System.out.println("Таких чисел нет!");
        System.out.println("Числа, длина которых, больше средней: ");
        for (String i : array) {
            if (i.length() > average) {
                System.out.println(i + " - его длина: " + i.length());
                counter = 1;
            }
        }
        if (counter == 0) System.out.println("Таких чисел нет!");

    }

    //  4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
//5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
//6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
//7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    void differentNumbers() {




    }

    //8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
    void showArray() {
        System.out.print("Введите размерность матрицы NxN: ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i * n + j + 1 + " ");
            }
            System.out.println();
        }
    }
}

