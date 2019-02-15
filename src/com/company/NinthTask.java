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
    //----Первый вариан--в матрице сдвигаются все элементы влево-------------------------------------------------------
    /*void moveElementLeft1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу влево: ");
        int step = sc.nextInt();
        if (step > length * length || step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length * length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            int[] arrayNew = new int[length * length];
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    arrayNew[row * array[0].length + col] = array[row][col];
                }
            }
            for (int i = 0; i < length * length; i++) {
                System.out.print(arrayNew[i] + " ");
            }
            for (int i = 0; i < step; i++) {
                leftRotate(arrayNew, length * length);
            }
            System.out.println("Матрица сдвинутая на " + step + " элементов(-та) влево:");
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    System.out.print(arrayNew[row * length + col] + " ");
                }
                System.out.println();

            }
        }
    }

    private void leftRotate(int[] matrix, int size) {
        int i, temp;
        temp = matrix[0];
        for (i = 0; i < size - 1; i++) {
            matrix[i] = matrix[i + 1];
        }
        matrix[i] = temp;
    }*/

    //--Второй вариан--в матрице сдвигаются влево элементы каждой строки------------------------------------------------
    void moveElementLeft2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов, на которое нужно сдвинуть матрицу влево: ");
        int step = sc.nextInt();
        if (step > length || step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            //-------------Первый вариант---------------------------------------------------------
            System.out.println("Матрица сдвинутая на " + step + " элементов(-та) влево:");
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
        if (step > length || step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            System.out.println("Матрица сдвинутая на " + step + " элементов(-та) вправо:");
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
        if (step > length || step < 1) {
            System.out.println("Сдвиг невозможен!");
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else {
            System.out.println("Матрица сдвинутая на " + step + " строк(ки)  вниз:");
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
        if (step > length || step < 1) {
            // System.out.println("Сдвиг невозможен!");
            while (step > length - 1) {
                step = step - length;
            }
        } else if (step == length) {
            System.out.println("Матрица с таким здвигом имеет тот же вид, что и первоначальная!");
        } else  {
            System.out.println("Матрица сдвинутая на " + step + " строк(ки) вверх:");
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

    //---9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.------------------
//---9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.--
    void sumElements() {
        int[] arrayNew = new int[array.length * array[0].length];
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                arrayNew[row * array[0].length + col] = array[row][col];
            }
        }
        System.out.println();
        int sum = 0;
        for (int row = 0; row < length; row++) {
            int sum1 = 0;
            int first = -1, second = -1;
            for (int col = 0; col < length; col++) {
                if (arrayNew[row * length + col] >= 0) {
                    if (first == -1) {
                        first = row * length + col;
                    } else if (second == -1) {
                        second = row * length + col;
                    } else {
                        break;
                    }
                }
            }
            if (first != -1 && second != -1 && second > first) {
                for (int m = first + 1; m < second; m++) {
                    sum1 += arrayNew[m];
                }
            }
            sum += sum1;
            System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными элементами " + row + " строки: " + sum);
            sum = 0;
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

