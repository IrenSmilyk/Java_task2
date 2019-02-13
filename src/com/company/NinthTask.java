package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class NinthTask {

    private int[][] array;
    private int length;

    /*--9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений---------
    ---от -n до n с помощью датчика случайных чисел.---------------------------------------------------------------------*/
    void sedArray() {
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        Random ran = new Random();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                array[row][col] = ran.nextInt(length + length) - length;
            }
        }
    }

    void showArray1() {
        for (int[] row : array) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }
    }

    //----9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.----------------------------------------
    void sortRowColumn() {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                for (int k = col + 1; k < length; k++) {
                    if (array[row][col] > array[row][k]) {
                        int temp = array[row][k];
                        array[row][k] = array[row][col];
                        array[row][col] = temp;
                    }
                }
            }
        }
        System.out.println("Матрица с упорядоченными строками в порядке возрастания значений: ");
        showArray1();

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                for (int j = row + 1; j < length; j++) {
                    if (array[row][col] > array[j][col]) {
                        int temp = array[j][col];
                        array[j][col] = array[row][col];
                        array[row][col] = temp;
                    }
                }
            }
        }

        System.out.println("Матрица с упорядоченными столбцами в порядке возрастания значений: ");
        showArray1();
    }

    //---9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).-----------------------
    /*void moveElement() {

    }*/
//---9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.------------------
//---9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.--
   /* void sumElements() {

    }*/

    //---9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.----------------------------------------
    void rotateMatrix() {

        for (int row = 0; row < length / 2; row++) {
            for (int col = row; col < length - row - 1; col++) {
                int temp = array[row][col]; //сохраняем текущую ячейку во временной переменной
                array[row][col] = array[col][length - 1 - row]; // перемещаем значение справа налево
                array[col][length - 1 - row] = array[length - 1 - row][length - 1 - col]; // перемещаем значения снизу вправо
                array[length - 1 - row][length - 1 - col] = array[length - 1 - col][row]; // перемещаем значения слева направо
                array[length - 1 - col][row] = temp;
            }
        }

    }

    void rotate2Matrix() {
        System.out.println("Матрица повернутая на 180 градусов: ");
        rotateMatrix();
        showArray1();
        System.out.println("Матрица повернутая на 270 градусов: ");
        rotateMatrix();
        showArray1();
    }

    //---9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.----------------------
    void minusAverage() {
        int sum = 0;
        int average;
        int l = 0;
        System.out.print("Среднее арефметическое: ");
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                sum = sum + array[row][col];
                l++;
            }
            average = sum / l;
            System.out.print(average + ", ");
            sum = 0;
            l = 0;
            for (int col1 = 0; col1 < array.length; col1++) {
                array[row][col1] = array[row][col1] - average;
            }
        }
        System.out.println("\nМатрица, в кторой из элементов каждой строки вычли ее среднее арифметическое: ");
        showArray1();
    }
    //---9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.----------------------------------------
   /* void removeRow() {

    }*/
    //---9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.--
    void moveZero() {
        for (int row = 0; row < array.length; row++) {
            int n = 0;
            int[] c = new int[array.length];
            for (int col = 0; col < array.length; col++) {
                if (array[row][col] != 0) {
                    c[n++] = array[row][col];
                }
            }
            array[row] = Arrays.copyOf(c, c.length);
        }
        System.out.println("Матрица в которой элементы, равные нулю, располагаются после всех остальных: ");
        showArray1();
    }
}

