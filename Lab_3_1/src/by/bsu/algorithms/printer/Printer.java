package by.bsu.algorithms.printer;

import by.bsu.algorithms.classes.Edge;

public class Printer {

    public static void printMatrix(int[][]matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + ";");
            }
            System.out.println();
        }
    }

    public static void printEdgesArray(Edge[] edges){
        for (Edge edge : edges) {
            System.out.println(edge.toString());
        }
        System.out.println();
    }
}
