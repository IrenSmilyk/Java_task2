package com.company;

public class Main {

    public static void main(String[] args) {
        FirstEighthTask firstTask = new FirstEighthTask();
        firstTask.setArray();
        firstTask.showShortLongNumber();
        firstTask.sortNumbers();
        firstTask.showAverageLength();
        firstTask.minDifferentNumbers();
        firstTask.colEvenNumbers();
        firstTask.numbersInAscendingOrder();
        firstTask.differentNumbers();
        firstTask.showArray();
        NinthTask ninthTask = new NinthTask();
        boolean m = ninthTask.sedArray();
        if (m) {
            System.out.println("Матрица со случайными числами: ");
            ninthTask.showArray1();
            ninthTask.sortRowColumn();
            // ninthTask.moveElementLeft1();
            ninthTask.moveElementLeft2();
            ninthTask.moveElementRight();
            ninthTask.moveElementDown();
            ninthTask.moveElementUp();
            ninthTask.maxCountElement();
            ninthTask.sumElements();
            System.out.println("Матрица повернутая на 90 градусов: ");
            ninthTask.rotateMatrix();
            ninthTask.showArray1();
            ninthTask.rotate2Matrix();
            ninthTask.minusAverage();
            ninthTask.moveZero();
            //ninthTask.removeRow();
        }

    }
}
