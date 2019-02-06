package com.company;

public class Main {

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        firstTask.showShortLongNumber();
        SecondTask secondTask = new SecondTask();
        secondTask.sortArray(firstTask.array);
    }
}
