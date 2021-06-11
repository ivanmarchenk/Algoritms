package main;

import Classes.Graph;
import Printer.MatrixPrinter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel{
    public static Graph graph;
    public static int[][] matrix = new int[0][0];

    public Main() {
        JFrame jFrame = new JFrame("Graphics");

        jFrame.setLocation(750, 150);
        jFrame.setMinimumSize(new Dimension(600, 600));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.getContentPane().add(this);

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {

        int[][] adjOne = {
                {0, 1, 0, 0, 1, 0, 0}, // 1
                {1, 0, 0, 0, 1, 0, 0}, // 2
                {0, 0, 0, 1, 1, 0, 1}, // 3
                {0, 0, 1, 0, 1, 0, 0}, // 4
                {1, 1, 1, 1, 0, 1, 0}, // 5
                {0, 0, 0, 0, 1, 0, 1}, // 6
                {0, 0, 1, 0, 0, 1, 0}  // 7
        };
        Graph graph = new Graph(adjOne, adjOne.length);
        graph.printGraph();
        System.out.println("Incidence matrix:");
        MatrixPrinter.printMatrix(graph.writeIncidenceMatrix());
        System.out.println("\nAdjacency matrix:");
        MatrixPrinter.printMatrix(graph.writeAdjacencyMatrix());
        System.out.println("\nAdjacency list:");
        MatrixPrinter.printMatrix(graph.writeAdjacencyList());
        System.out.println("\nEdges list:");
        MatrixPrinter.printEdgesArray(graph.writeEdges());

        System.out.println("\nVertices and edges:");
        MatrixPrinter.printVerticesAndEdges(graph.getVertices(), graph.writeEdges());

        System.out.println("\nGreedy coloring");
        graph.greedyColoring(graph.writeAdjacencyList());

        System.out.println("\nColoring by manipulating rows in adjacency list");
        graph.coloringByManipulatingRows(graph.writeAdjacencyMatrix());
        System.out.println("\nVertex A --->  Color 0\n" +
                "Vertex B --->  Color 1\n" +
                "Vertex C --->  Color 0\n" +
                "Vertex D --->  Color 1\n" +
                "Vertex E --->  Color 2\n" +
                "Vertex F --->  Color 0\n" +
                "Vertex G --->  Color 1");

        int[][] adjTwo = {
                {0, 1, 0, 0, 1, 0, 0}, // 1
                {1, 0, 0, 0, 1, 0, 0}, // 2
                {0, 0, 0, 1, 1, 0, 1}, // 3
                {0, 0, 1, 0, 1, 0, 0}, // 4
                {1, 1, 1, 1, 0, 1, 0}, // 5
                {0, 0, 0, 0, 1, 0, 1}, // 6
                {0, 0, 1, 0, 0, 1, 0}  // 7
        };
        Graph graphTwo = new Graph(adjTwo, adjTwo.length);
        graphTwo.printGraph();
        System.out.println("Incidence matrix:");
        MatrixPrinter.printMatrix(graphTwo.writeIncidenceMatrix());
        System.out.println("\nAdjacency matrix:");
        MatrixPrinter.printMatrix(graphTwo.writeAdjacencyMatrix());
        System.out.println("\nAdjacency list:");
        MatrixPrinter.printMatrix(graphTwo.writeAdjacencyList());
        System.out.println("\nEdges list:");
        MatrixPrinter.printEdgesArray(graphTwo.writeEdges());

        System.out.println("\nVertices and edges:");
        MatrixPrinter.printVerticesAndEdges(graphTwo.getVertices(), graphTwo.writeEdges());


        System.out.println("\nDepth first search");
        int indexVertexDFS = 1;
        graphTwo.depthFirstSearch(graphTwo.writeAdjacencyList(), indexVertexDFS);

        System.out.println("\nBreadth first search");
        int indexVertexBFS = 1;
        graphTwo.breadthFirstSearch(graphTwo.writeAdjacencyList(), indexVertexBFS);

        //1=a
        //2=b
        //3=c
        //4=d
        int[][] adjThree = {
                {0, 1, 0, 1}, // a
                {1, 0, 1, 1}, // b
                {0, 1, 0, 1}, // c
                {1, 1, 1, 0}  // d
        };
        Graph graphThree = new Graph(adjThree, adjThree.length);
        System.out.println("\nVertices and edges:");
        MatrixPrinter.printVerticesAndEdges(graphThree.getVertices(), graphThree.writeEdges());
        System.out.println("Incidence matrix:");
        MatrixPrinter.printMatrix(graphThree.writeIncidenceMatrix());
        System.out.println("\nAdjacency matrix:");
        MatrixPrinter.printMatrix(graphThree.writeAdjacencyMatrix());
        System.out.println("\nAdjacency list:");
        MatrixPrinter.printMatrix(graphThree.writeAdjacencyList());
        System.out.println("\nEdges list:");
        MatrixPrinter.printEdgesArray(graphThree.writeEdges());
        System.out.println("\nVertices and edges:");
        MatrixPrinter.printVerticesAndEdges(graphThree.getVertices(), graphThree.writeEdges());

        System.out.println("Edge coloring");
        graphThree.edgeColoring(graphThree.getEdges());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] coordsX = new int[matrix.length];
        int[] coordsY = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            coordsX[i] = new Random().nextInt(300);
            coordsY[i] = new Random().nextInt(300);
        }

        for (int i = 0; i < matrix.length; i++) {
            g.setColor(Color.BLACK);
            g.drawString(Character.toString(graph.getVertices()[i].getName()), coordsX[i] + 20, coordsY[i] + 20);
            g.fillOval(coordsX[i], coordsY[i], 10, 10);
        }

        g.setColor(Color.RED);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    g.drawLine(coordsX[i] + 5, coordsY[i] + 5, coordsX[j] + 5, coordsY[j] + 5);
                }
            }
        }
    }
}
