package by.bsu.algs.main;

import by.bsu.algs.algorithm.algorithm;
import by.bsu.algs.classes.arrayClass;
import by.bsu.algs.functions.arrayCreator;
import by.bsu.algs.functions.arrayReader;
import by.bsu.algs.functions.stringFilter;

import java.util.Arrays;

class Main {
    static final int COUNT_ELEMENTS = 10_000_000;
    static final int START = -100_000;
    static final int END = 100_000;
    static final int KEY = 1_500;

    public static void main(String[] args) {

        arrayCreator arrayCreator = new arrayCreator();
        int[] array = arrayCreator.createArray(COUNT_ELEMENTS);
        array = arrayCreator.createRandomArray(START, END, array);
        Arrays.sort(array);
        algorithm algorithm = new algorithm();
        long start = System.nanoTime();
        System.out.println(algorithm.dichotomousSearch(array, KEY));
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Count of elements=" + COUNT_ELEMENTS);
        System.out.println("Time: " + elapsed);



        /*System.out.println("Enter the array of integer values:");
        arrayReader reader = new arrayReader();
        String[] strings = reader.readStringArray(System.in);
        stringFilter filter = new stringFilter();
        arrayCreator creator = new arrayCreator();
        int[] arrayNumbers = creator.factoryArray(stringNumbers);
        System.out.println("Initial array:");
        arrayClass arrayClass = new arrayClass();
        arrayClass.print(arrayNumbers);
        System.out.println("Enter key");
        int key = reader.readIntegerNumber(System.in);
        Arrays.sort(arrayNumbers);
        System.out.println("Sorted array:");
        arrayClass.printWithIndexes(arrayNumbers);
        algorithm algorithm = new algorithm();
        long startTime = System.nanoTime();
        System.out.println(algorithm.dichotomousSearch(arrayNumbers, key));
        long endTime = System.nanoTime();
        System.out.println("Lead time=" + (endTime - startTime));*/

    }
}