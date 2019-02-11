package com.company;

import java.util.Random;
import java.util.Scanner;

class FirstEighthTask {
    private String[] array;
    private String minStr = null;
    private String maxStr = null;
    private Scanner scan = new Scanner(System.in);
    private int sum = 0;

    void setArray() {
        String input;
        System.out.print("Введите числа: ");
        input = scan.nextLine();
        array = input.split("\\s+");
    }

    /*-- Ввести n чисел с консоли.----------------------------------------------------------------------------------------
                 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.*/
//-----------Первый вариант-------------------------------------------------------------------------------------------
    void showShortLongNumber() {
        int minCol = 1000;
        int maxCol = 0;
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

//-----------Второй вариант-------------------------------------------------------------------------------------------
    /*void showShortLongNumber() {
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

    //---2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.------------------------------
    void sortNumbers() {
        System.out.print("Длина введенных чисел: ");
        for (String i : array) {
            System.out.print(i.length() + "  ");
            sum += i.length();
        }

        System.out.print("\nЧисла в порядке возрастания значений их длины: ");
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

    //---3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.----------------------------
    void showAverageLength() {
        int average;
        int counter = 0;
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

    //--4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.--------
    void minDifferentNumbers() {
        long[] arrayNumbers = new long[array.length];
        int min = 10;
        long c = 0;
        for (int i = 0; i < array.length; i++) {
            arrayNumbers[i] = Long.parseLong(array[i]);
        }
        System.out.println("Числа и количество различных чисел в них:");
        for (long k : arrayNumbers) {
            String a = String.valueOf(k);
            char[] a1 = a.toCharArray();
            int[] arrayNum = new int[a1.length];

            for (int i = 0; i < a1.length; i++) {
                arrayNum[i] = Character.getNumericValue(a1[i]);
            }

            for (int bar = arrayNum.length - 1; bar >= 0; bar--) {
                for (int j = 0; j < bar; j++) {
                    if (arrayNum[j] > arrayNum[j + 1]) {
                        int tmp = arrayNum[j];
                        arrayNum[j] = arrayNum[j + 1];
                        arrayNum[j + 1] = tmp;
                    }
                }
            }

            int count = 1;
            for (int i = 1; i < arrayNum.length; i++) {
                if (arrayNum[i] != arrayNum[i - 1]) {
                    count++;
                }
            }

            System.out.print(k + " - " + count + ", ");
            if (count < min) {
                min = count;
                c = k;
            }
        }
        System.out.println("\nЧисло, в котором число различных цифр минимально: " + c);
    }

    //----5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и
// ------------------------------нечетных цифр.-----------------------------------------------------------------------
    void colEvenNumbers() {
        long[] arrayNumbers = new long[array.length];
        int count1 = 0;
        int i;
        int counter = 0;

        for (i = 0; i < array.length; i++) {
            arrayNumbers[i] = Long.parseLong(array[i]);
        }

        System.out.print("Числа, что Вы ввели: ");
        for (long arrayNumber : arrayNumbers) {
            System.out.print(arrayNumber + ", ");
        }

        for (i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.print("\nКоличество четных чисел: " + counter);

        for (i = 0; i < arrayNumbers.length; i++) {
            int counterEven = 0;
            int counterOdd = 0;
            if (arrayNumbers[i] % 2 == 0) {
                String a = String.valueOf(arrayNumbers[i]);
                char[] a1 = a.toCharArray();
                int[] arrayNum = new int[a1.length];
                for (int j = 0; j < a1.length; j++) {
                    arrayNum[j] = Character.getNumericValue(a1[j]);
                }
                for (int j : arrayNum) {
                    if (j % 2 == 0) {
                        counterEven++;
                    } else counterOdd++;
                }
                if (counterEven == counterOdd) {
                    count1++;
                }
            }
        }
        System.out.println("\nКоличество чисел с равным числом четных и нечетных цифр среди четных чисел: " + count1);
    }

    //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    void numbersInAscendingOrder() {
        long[] arrayNumbers = new long[array.length];
        int i;
        int count = 0;
        int flag = 0;

        for (i = 0; i < array.length; i++) {
            arrayNumbers[i] = Long.parseLong(array[i]);
        }

        System.out.print("Число, цифры в котором идут в строгом порядке возрастания: ");
        exit:
        {
            for (long i1 : arrayNumbers) {
                String a = String.valueOf(i1);
                char[] a1 = a.toCharArray();
                int[] arrayNum = new int[a1.length];
                for (int j = 0; j < a1.length; j++) {
                    arrayNum[j] = Character.getNumericValue(a1[j]);
                }
                for (int k = 0; k < arrayNum.length - 1; k++) {
                    for (int l = k + 1; l < arrayNum.length; l++) {
                        if (arrayNum[k] > arrayNum[l]) {
                            int tmp = arrayNum[l];
                            arrayNum[l] = arrayNum[k];
                            arrayNum[k] = tmp;
                            count = 1;
                        }
                    }
                }
                if (count == 0) {
                    System.out.println(i1 + " ");
                    flag = 1;
                    break exit;
                }
                count = 0;
            }
        }

        if (flag == 0) {
            System.out.println("Таких чисел нет!");
        }
    }

    //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    void differentNumbers() {
        int flag = 0;
        long[] arrayNumbers = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayNumbers[i] = Long.parseLong(array[i]);
        }
        System.out.print("Число, состоящее только из различных цифр: ");
        exit:
        {
            for (long k : arrayNumbers) {
                String a = String.valueOf(k);
                char[] a1 = a.toCharArray();
                int[] arrayNum = new int[a1.length];

                for (int i = 0; i < a1.length; i++) {
                    arrayNum[i] = Character.getNumericValue(a1[i]);
                }

                for (int bar = arrayNum.length - 1; bar >= 0; bar--) {
                    for (int j = 0; j < bar; j++) {
                        if (arrayNum[j] > arrayNum[j + 1]) {
                            int tmp = arrayNum[j];
                            arrayNum[j] = arrayNum[j + 1];
                            arrayNum[j + 1] = tmp;
                        }
                    }
                }

                int counter = 0;
                d:
                {
                    for (int i = 1; i < arrayNum.length; i++) {
                        if (arrayNum[i] != arrayNum[i - 1]) {
                            counter++;
                        } else {
                            counter = 0;
                            break d;
                        }
                    }
                }
                if (counter != 0) {
                    System.out.println(k);
                    flag = 1;
                    break exit;
                }
            }
        }
        if (flag == 0) {
            System.out.println("Таких чисел нет!");
        }
    }

    //8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
    void showArray() {
        //-----Первый вариант------------------------------------------------------------------
        System.out.print("Введите размерность матрицы NxN: ");
        int n = scan.nextInt();
        System.out.printf("Числа от 1 до %d в виде матрицы %dx%d слева направо и сверху вниз!\n", n * n, n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i * n + j + 1 + " ");
            }
            System.out.println();
        }
//-----Второй вариант------------------------------------------------------------------
      /*  String[] array1;
        int j;
        int n;
        int k;

        System.out.print("Введите размерность матрицы NxN: ");
        n = scan.nextInt();
        do {
            System.out.print("Введите " + n * n + " чисел (числа) и нажмите <Enter>: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            array1 = input.split("\\s+");
            int len = array1.length;
            j = 0;
            if (len < n * n) {
                System.out.println("Вы ввели мало чисел!");
                k = 1;
            } else if (len > n * n) {
                System.out.println("Вы ввели много чисел!");
                k = 1;
            } else
                k = 0;
        } while (k != 0);
        System.out.printf("Ваши числа в виде матрицы %dx%d!\n", n, n);
        for (int i = 0; i < array1.length; i = i + n) {
            while (j < n) {
                System.out.print(array1[i + j] + " ");
                j++;
            }
            System.out.println();
            j = 0;
        }*/
//-----Третий вариант-------------------------------------------------------------------------------------------------
       /* System.out.print("Введите размерность матрицы NxN: ");
        int n = scan.nextInt();
        Random ran = new Random();
        int j = 0;
        int m = n * n;
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = ran.nextInt(m - 1) + 1;
        }
        System.out.print("Массив случайных чисел: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i = i + n) {
            while (j < n) {
                System.out.print(array[i + j] + " ");
                j++;
            }
            System.out.println();
            j = 0;
        }*/
    }
}

