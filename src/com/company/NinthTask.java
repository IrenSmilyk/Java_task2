package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class NinthTask {


    private int[][] array;

    void sedArray() {
        int length;
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        Random ran = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ran.nextInt(100);
            }
        }
    }

    void showArray() {
       /* for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }*/
        System.out.println(Arrays.deepToString(array));
    }
}
