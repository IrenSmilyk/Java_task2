package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class NinthTask {

    private int[][] array;
    private int length;

    /*--9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений---------
   ---от -n до n с помощью датчика случайных чисел.---------------------------------------------------------------------*/
    boolean sedArray() {
        boolean k;
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        Random ran = new Random();
        if (length <= 1) {
            System.out.println("Невозможно создать матрицу такой длины!");
            k = false;
        } else {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ran.nextInt(length + length) - length;
                }
            }
            k = true;
        }
        return k;
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

//---9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).--------------------
    void moveElementLeft() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу влево: ");
        int step = sc.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int m = step;
            while (step > length - 1) {
                step = step - length;
            }
            //-------------Первый вариант---------------------------------------------------------
            System.out.println("Матрица сдвинута на " + m + " элементов(-та) влево:");
            /*for (int j = 0; j < length; j++) {
                for (int row = step; row < length; row++)
                    System.out.print(array[j][row] + " ");

                for (int row = 0; row < step; row++)
                    System.out.print(array[j][row] + " ");
                System.out.println();
            }*/
            //------------Второй вариант---------------------------------------------------------
            int j;
            for (int row = 0; row < length; row++) {
                for (int k = 0; k < step; k++) {
                    int temp = array[row][0];
                    for (j = 0; j < length - 1; j++) {
                        array[row][j] = array[row][j + 1];
                    }
                    array[row][length - 1] = temp;
                }
            }
            showArray1();
        }
    }

    void moveElementRight() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вправо: ");
        int step = sc.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int m = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица сдвинута на " + m + " элементов(-та) вправо:");
            int j;
            for (int row = 0; row < length; row++) {
                for (int k = 0; k < step; k++) {
                    int temp = array[row][length - 1];
                    for (j = length - 1; j > 0; j--) {
                        array[row][j] = array[row][j - 1];
                    }
                    array[row][0] = temp;
                }
            }
            showArray1();
        }
    }

    void moveElementDown() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вниз: ");
        int step = sc.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int m = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица сдвинута на " + m + " строк(ки) вниз:");
            int temp, i, j;
            for (int row = 0; row < step; row++) {
                for (i = 0; i < length; i++) {
                    temp = array[length - 1][i];
                    for (j = length - 1; j > 0; j--) {
                        array[j][i] = array[j - 1][i];
                    }
                    array[j][i] = temp;
                }
            }
            showArray1();
        }
    }

    void moveElementUp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вверх: ");
        int step = sc.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int m = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица сдвинутая на " + m + " строк(ки) вверх:");
            int temp, i, j;
            for (int row = 0; row < step; row++) {
                for (i = 0; i < length; i++) {
                    temp = array[0][i];
                    for (j = 0; j < length - 1; j++) {
                        array[j][i] = array[j + 1][i];
                    }
                    array[j][i] = temp;
                }
            }
            showArray1();
        }
    }

    //---9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.---------------
    void maxCountElement() {
        int n, countMax, countMin;
        int maxRow = 0, minRow = 0;
        int max = 0, min = 0;
        int indexRow = 0, index1Row = 0;
        int indexMax, indexMin = 0;
        String s = null, s1 = null;
        for (int row = 0; row < length; row++) {
            countMax = 0;
            countMin = 0;
            for (n = 0; n < length - 1; n++) {
                if (array[row][n] < array[row][n + 1]) {
                    countMax++;
                    if (countMax >= maxRow) {
                        maxRow = countMax;
                        indexRow = n + 1; //запоминаем индекс последнего возрастающего элемента
                    }
                } else {
                    countMax = 0;
                }
                if (array[row][n] > array[row][n + 1]) {
                    countMin++;
                    if (countMin > minRow) {
                        minRow = countMin;
                        index1Row = n + 1; //запоминаем индекс последнего убывающего элемента
                    }
                } else {
                    countMin = 0;
                }
            }
            if (maxRow > max) {
                max = maxRow;
                indexMax = indexRow;
                int[] c = new int[max + 1];
                int l = 0;
                for (int col = indexMax - max; col <= indexMax; col++) {
                    c[l++] = array[row][col];
                }
                s = Arrays.toString(c);
            }
            if (minRow > min) {
                min = minRow;
                indexMin = index1Row;
                int[] d = new int[min + 1];
                int l1 = 0;
                for (int col = indexMin - min; col <= indexMin; col++) {
                    d[l1++] = array[row][col];
                }
                s1 = Arrays.toString(d);
            }
        }
        System.out.print("Максимальная последовательность возрастающих чисел: ");
        if (max == 0) {
            System.out.println("Такой последовательности нет!");
        } else {
            System.out.println(s + " " + (max + 1));
        }
        System.out.print("Максимальная последовательность убывающих чисел: ");
        if (min == 0) {
            System.out.println("Такой последовательности нет!");
        } else {
            System.out.println(s1 + " " + (min + 1));
        }
    }

    //---9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.--
    void sumElements() {
        for (int row = 0; row < length; row++) {
            int sum = 0;
            int first = -1, second = -1;
            for (int col = 0; col < length; col++) {
                if (array[row][col] >= 0) {
                    if (first == -1) {
                        first =col;
                    } else if (second == -1) {
                        second = col;
                    }
                }
            }
            if (first != -1 && second != -1 && second > first) {
                for (int m = first + 1; m < second; m++) {
                    sum += array[row][m];
                }
            }
            System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными элементами " + row + " строки: " + sum);
        }
    }

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
    void removeRow() {

    }

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

