package by.bsu.mmf.algs;

import java.util.Scanner;

public class mergeSort {

    private static void merge(int[] set, int low, int mid, int high) {

        int n = high-low+1;
        int[] Temp = new int[n];

        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = set[j++];
            else if (j > high)
                Temp[k++] = set[i++];
            else if (set[i] < set[j])
                Temp[k++] = set[i++];
            else
                Temp[k++] = set[j++];
        }
        for (j = 0; j < n; j++)
            set[low + j] = Temp[j];
    }

    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) { // list contains at least 2 elements
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid); // recursion : sort first half
            mergeSort(elements, mid + 1, high); // recursion : sort second half
            merge(elements, low, mid, high); // merge both sorted halves
        }
    }

    static void printArray(int[] array){

        for(int i=0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
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
        System.out.println("\n\n---Merge Sorting---");
        long start = System.nanoTime();
        mergeSort(array, 0, n - 1);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("\n---Array AFTER Merge Sort---");
        for (int h = 0; h < n; h++)
            System.out.print(array[h]+ " ");
        System.out.println("\nTime: " + elapsed);
    }

}
