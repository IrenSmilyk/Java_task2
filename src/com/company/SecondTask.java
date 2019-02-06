package com.company;

class SecondTask {
    private int[] arrayLength;
    //private FirstTask firstTask = new FirstTask();

    void sortArray(String [] array) {
        int j = 0;
        arrayLength = new int[array.length];
        for (String i : array) {
            arrayLength[j] = i.length();
            System.out.print(arrayLength[j] + " ");
        }
    }
}
