package com.company;

public class Main {

    public static void main(String[] args) {
        /*FirstEighthTask firstTask = new FirstEighthTask();
        firstTask.setArray();
        firstTask.showShortLongNumber();
        firstTask.sortNumbers();
        firstTask.showAverageLength();
        firstTask.minDifferentNumbers();
        firstTask.colEvenNumbers();
        firstTask.numbersInAscendingOrder();
        firstTask.differentNumbers();
        firstTask.showArray();*/
        NinthTask ninthTask = new NinthTask();
        boolean flag = ninthTask.sedArray();
        if (flag) {
            System.out.println("Матрица со случайными числами: ");
            ninthTask.showArray();
            ninthTask.sortRowColumn();
            ninthTask.moveElementLeft();
            ninthTask.moveElementRight();
            ninthTask.moveElementDown();
            ninthTask.moveElementUp();
            ninthTask.maxCountElement();
            ninthTask.sumElements();
            System.out.println("Матрица повернутая на 90 градусов: ");
            ninthTask.rotateMatrix();
            ninthTask.showArray();
            ninthTask.rotate2Matrix();
            ninthTask.minusAverage();
            ninthTask.moveZero();
            ninthTask.removeRow();
        }

    }
}
