package by.bsu.mmf.algs;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //System.out.print("Input the size of matrix: ");
        //int n = in.nextInt();
        int a = 5;
        int b = 10000;
        int n = a + (int) (Math.random() * b);
        int i, j, even = 0, odd = 0;
        int matrix[][] = new int[n][n];

        Random random = new Random();

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt();
            }
        }
        long start = System.nanoTime();

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (matrix[i][j] % 2 == 0)
                {
                    even++;
                }
                else
                {
                    odd++;
                }
            }
        }
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println("Size oa matrix: " + n);
        System.out.println("Even: " + even + " | " + "Odd: " + odd);
        System.out.println("Time: " + timeConsumedMillis);

    }
}
