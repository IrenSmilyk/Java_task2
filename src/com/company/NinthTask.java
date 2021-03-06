package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class NinthTask {

    private int[][] array;
    private int length;
    private int[][] b;

    /*--9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений------
   ---от -n до n с помощью датчика случайных чисел.-------------------------------------------------------------------*/
    boolean sedArray() {
        boolean flag;
        System.out.print("Введите размерность матрицы: ");
        Scanner input = new Scanner(System.in);
        length = input.nextInt();
        array = new int[length][length];
        b = new int[length][length];
        Random ran = new Random();
        if (length <= 1) {
            System.out.println("Невозможно создать матрицу такой длины!");
            flag = false;
        } else {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ran.nextInt(length + length) - length;
                }
            }
            flag = true;
        }
        for (int row = 0; row < array.length; row++) {
            System.arraycopy(array[row], 0, b[row], 0, array.length);
        }

        return flag;
    }

    void showArray() {
        for (int[] row : array) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }
    }
    private void showArray1() {
        for (int[] row : b) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.print("\n");
        }
    }

    //----9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.-------------------------------------
    void sortRowColumn() {
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                for (int k = col + 1; k < length; k++) {
                    if (b[row][col] > b[row][k]) {
                        int temp = b[row][k];
                        b[row][k] = b[row][col];
                        b[row][col] = temp;
                    }
                }
            }
        }
        System.out.println("Матрица с упорядоченными строками в порядке возрастания значений: ");
        showArray1();

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                for (int j = row + 1; j < length; j++) {
                    if (b[row][col] > b[j][col]) {
                        int temp = b[j][col];
                        b[j][col] = b[row][col];
                        b[row][col] = temp;
                    }
                }
            }
        }

        System.out.println("Матрица с упорядоченными столбцами в порядке возрастания значений: ");
        showArray1();
    }

    //---9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).--------------------
    void moveElementLeft() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу влево: ");
        int step = scan.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int inputStep = step;
            while (step > length - 1) {
                step = step - length;
            }
            //-------------Первый вариант---------------------------------------------------------
            System.out.println("Матрица (до сортировки) сдвинута на " + inputStep + " элементов(-та) влево:");
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
            showArray();
        }
    }

    void moveElementRight() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вправо: ");
        int step = scan.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int inputStep = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица (до сортировки) сдвинута на " + inputStep + " элементов(-та) вправо:");
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
            showArray();
        }
    }

    void moveElementDown() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вниз: ");
        int step = scan.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int inputStep = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица (до сортировки) сдвинута на " + inputStep + " строк(ки) вниз:");
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
            showArray();
        }
    }

    void moveElementUp() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу вверх: ");
        int step = scan.nextInt();
        if (step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int inputStep = step;
            while (step > length - 1) {
                step = step - length;
            }
            System.out.println("Матрица (до сортировки) сдвинутая на " + inputStep + " строк(ки) вверх:");
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
            showArray();
        }
    }

    //---9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.---------------
    void maxCountElement() {
        int n, countMax, countMin;
        int maxRow = 0, minRow = 0;
        int max = 0, min = 0;
        int indexRow = 0, index1Row = 0;
        int indexMax, indexMin;
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
                        first = col;
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
            System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными элементами " +
                    +row + " строки: " + sum);
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
        showArray();
        System.out.println("Матрица повернутая на 270 градусов: ");
        rotateMatrix();
        showArray();
    }

    //---9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.-------------------
    void minusAverage() {
        int sum = 0;
        int average;
        int count = 0;
        System.out.print("Среднее арефметическое для каждой строки: ");
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                sum = sum + array[row][col];
                count++;
            }
            average = sum / count;
            System.out.print(average + ", ");
            sum = 0;
            count = 0;
            for (int col1 = 0; col1 < array.length; col1++) {
                array[row][col1] = array[row][col1] - average;
            }
        }
        System.out.println("\nМатрица, в кторой из элементов каждой строки вычли ее среднее арифметическое: ");
        showArray();
    }

    //---9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.----------------------------------------
    void removeRow() {
        int n = 5;
        int m = 5;
        int countRow;
        int countCol;
        int count = 0;
        int count1 = 0;
        int nrez, mrez, row, col, summ, flag;
        int[] flag_str = new int[n];
        int[] flag_stl = new int[m];
        nrez = n;
        mrez = m;
        int[][] array1 = {{1, 0, 2, 3, 0},
                         {0, 0, 0, 0, 0},
                         {4, 0, 5, 6, 0},
                         {7, 0, 8, 9, 0},
                         {0, 0, 0, 0, 0}};

        System.out.println("Матрица, в которой есть строки и столбцы, заполненные нулями: ");
        for (int[] i : array1) {
            for ( int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
        for ( row = 0; row < n; row++) {   //считаем количество строк, заполненных нулями
            countRow = 0;
            for ( col = 0; col < m; col++) {
                if (array1[row][col] == 0) {
                    countRow++;
                }
            }
            if (countRow == n) {
                count++;
            }
        }

        for ( row = 0; row < n; row++) {   //считаем количество солбцов, заполненных нулями
            countCol = 0;
            for ( col = 0; col < m; col++) {
                if (array1[col][row] == 0) {
                    countCol++;
                }
            }
            if (countCol == m) {
                count1++;
            }
        }

        if (count == 0 & count1 == 0) {
            System.out.println("В матрице отсутвуют строки и столбцы, заполненные нулями!");

        } else if (count == n & count1 == m) {
            System.out.println("Уплотнить матрицу невозможно, так как она состоит лишь из нулей!");

        } else {
            for (row = 0; row < n; row++) { //вычисляем на сколько строк уплотнится матрица и ищем строки, заполненные нулями
                summ = 0;
                for (col = 0; col < m; col++) {
                    summ += array1[row][col];

                }
                if (summ == 0) {
                    nrez--;
                    flag_str[row] = 1;
                } else flag_str[row] = 0;
            }
            int[][] temp = new int[nrez][m]; // создаем временную матрицу

            // удаляем из исходной матрицы строки, заполненные нулями
            flag = 0;
            for (row = 0; row < n; row++) {
                if (flag_str[row] == 0) { //если элемент массива равен нулю,
                    for (col = 0; col < m; col++) {
                        temp[row - flag][col] = array1[row][col];//то из исходной матрицы переносим все элементы строки в новую матрицу
                    }
                } else flag++;
            }

            for (col = 0; col < m; col++) { //вычисляем на сколько столбцов уплотнится матрица и ищем столбцы, заполненные нулями
                summ = 0;
                for (row = 0; row < nrez; row++) {
                    summ += array1[row][col];
                }
                if (summ == 0) {
                    mrez--;
                    flag_stl[col] = 1;
                } else flag_stl[col] = 0;
            }
            int[][] rez = new int[nrez][mrez]; // создаем конечную матрицу

            // удаляем из временной матрицы столбцы, заполненные нулями
            flag = 0;
            for (col = 0; col < m; col++) {
                if (flag_stl[col] == 0) { //если элемент массива равен нулю,
                    for (row = 0; row < nrez; row++) {
                        rez[row][col-flag] = temp[row][col];//то из исходной матрицы переносим все элементы столбца в новую матрицу
                    }
                } else flag++;
            }

            System.out.println("Матрица после уплотнения");
            for (row = 0; row < nrez; row++) {
                for (col = 0; col < mrez; col++) {
                    System.out.print(rez[row][col] + "\t");
                }
                System.out.print("\n");
            }
        }
    }

    //---9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.--
    void moveZero() {
        for (int row = 0; row < array.length; row++) {
            int indexNewArray = 0;
            int[] c = new int[array.length];
            for (int col = 0; col < array.length; col++) {
                if (array[row][col] != 0) {
                    c[indexNewArray++] = array[row][col];
                }
            }
            array[row] = Arrays.copyOf(c, c.length);
        }
        System.out.println("Матрица в которой элементы, равные нулю, располагаются после всех остальных: ");
        showArray();
    }
}

