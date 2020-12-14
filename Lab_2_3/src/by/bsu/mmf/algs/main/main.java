package by.bsu.mmf.algs.main;

import by.bsu.mmf.algs.algorithm.recursiveDichtomSearch;
import by.bsu.mmf.algs.functions.arrayCreator;
import by.bsu.mmf.algs.functions.arrayReader;
import by.bsu.mmf.algs.classes.arrayClass;

import java.util.Arrays;

public class main {
    static final int COUNT_ELEMENTS = 1000000;
    static final int START = 1;
    static final int END = 100;
    static final int LEFT = 0;

    public static void main(String[] args) {
        arrayCreator arrayCreator = new arrayCreator();
        int[] arrayNumbers = arrayCreator.createArray(COUNT_ELEMENTS);
        arrayNumbers = arrayCreator.createRandomArray(START, END, arrayNumbers);

        arrayClass arrayClass = new arrayClass();
        arrayClass.print(arrayNumbers);
        Arrays.sort(arrayNumbers);
        arrayClass.printWithIndexes(arrayNumbers);
        recursiveDichtomSearch algorithm = new recursiveDichtomSearch();
        arrayReader reader = new arrayReader();
        System.out.println("Enter key:");
        int key = reader.reader(System.in);
        long start = System.nanoTime();
        int position = algorithm.recursiveDichtomSearch(arrayNumbers, LEFT, arrayNumbers.length-1, key);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("Time: " + elapsed);
        if (position == -1){
            System.out.println("There is no such key");
        } else {
            System.out.println("Key " + key + " found at number " + position);
        }
    }
}
