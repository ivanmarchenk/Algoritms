package by.bsu.mmf.algs;

import java.util.Scanner;

public class bubbleSort {

    static void bubbleSort(int[] array)
    {
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++) // Looping through the array length
        {
            for(int j=1; j < (n-i); j++)
            {
                if(array[j-1] > array[j])
                {
                    //swap elements
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    System.out.println("Swapping Elements: New Array After Swap");
                    printArray(array);
                }
            }
        }
    }

    static void printArray(int[] array){

        for(int i=0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число n:");
        int n = sc.nextInt();
        int array[] = new int[n];
        System.out.println("\n---Array BEFORE Sort---");

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * 100);
            System.out.print(array[i] + " ");
        }

        System.out.println("\n\n---Bubble Sorting---");
        long start = System.nanoTime();
        bubbleSort(array);//sorting array elements using bubble sort
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("\n---Array AFTER Bubble Sort---");

        printArray(array);
        System.out.println("\nTime: " + elapsed);
    }
}
