package Main;

import Algorithms.Algorithms;

public class Main {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {Integer.MAX_VALUE, 3, 5, 10, Integer.MAX_VALUE, 8},
                {12, Integer.MAX_VALUE, 2, 4, 15, 10},
                {5, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 6},
                {10, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, 12, 8},
                {5, 15, 5, 12, Integer.MAX_VALUE, 3},
                {8, 10, 6, 8, 3, Integer.MAX_VALUE}};

        /*Integer[][] matrix = {
                {Integer.MAX_VALUE, 10, 2, 3, 5, 7},
                {10, Integer.MAX_VALUE, 5, 10, 15, 3},
                {4, 5, Integer.MAX_VALUE, 6, 5, 2},
                {3, 10, 6, Integer.MAX_VALUE, 7, 15},
                {Integer.MAX_VALUE, 15, 5, 3, Integer.MAX_VALUE, 2},
                {7, 3, Integer.MAX_VALUE, 15, 2, Integer.MAX_VALUE}};*/

        matrix = Algorithms.floydAlgorithm(matrix);

        System.out.println("Little's algorithm");
        Algorithms.littleAlgorithm(matrix);
    }
}