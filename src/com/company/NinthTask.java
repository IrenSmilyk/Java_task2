package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class NinthTask {


    private int[][] array;
    private int length;

    void sedArray() {

        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        Random ran = new Random();
        Scanner low = new Scanner(System.in);
        System.out.print("Введите нижнее значение интервала случайных чисел: ");
        int low1 = low.nextInt();
        System.out.print("Введите верхнее значение интервала случайных чисел: ");
        int height = low.nextInt();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ran.nextInt(height - low1) + 1;
            }
        }
    }

    void showArray1() {
        System.out.printf("Матрица %dx%d:\n", length, length);
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }

    void sortRowColumn() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (array[i][j] > array[i][k]) {
                        int temp = array[i][k];
                        array[i][k] = array[i][j];
                        array[i][j] = temp;
                    }
                }
            }
        }
        System.out.println("Матрица с упорядоченными строками в порядке возрастания значений: ");
        showArray1();

        /*for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int l = 0; l <length ; l++) {
                    if (array[i][l] < array[j][l]) {
                        for (int k = 0; k < length; k++) {
                            int temp = array[i][k];
                            array[i][k] = array[j][k];
                            array[j][k] = temp;
                        }

                    }
                }
            }
        }

        System.out.println("Матрица с упорядоченными столбцами в порядке возрастания значений: ");
        showArray1();*/
    }
}

