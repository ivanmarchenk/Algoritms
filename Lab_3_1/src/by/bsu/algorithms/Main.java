package by.bsu.algorithms;

import by.bsu.algorithms.classes.Edge;
import by.bsu.algorithms.classes.Graph;
import by.bsu.algorithms.classes.Vertex;
import by.bsu.algorithms.printer.Printer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
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
            g.drawString(Character.toString(graph.getVertices()[i].getName()),coordsX[i]+20,coordsY[i]+20);
            g.fillOval(coordsX[i], coordsY[i], 10, 10);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    g.drawLine(coordsX[i] + 5, coordsY[i] + 5, coordsX[j] + 5, coordsY[j] + 5);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main htd = new Main();

        //Вводим матрицу смежности
        int[][] adj = {
                {0,1,0,0,1,0},
                {1,0,1,0,1,0},
                {0,1,0,1,0,0},
                {0,0,1,0,1,1},
                {1,1,0,1,0,0},
                {0,0,0,1,0,0}
        };
        //С её помощью генерируем и рисуем новый граф
        Graph firstGraph = new Graph(adj, adj.length);
        firstGraph.printGraph();
        //Считаем и выводим матрицу инцидентности
        System.out.println("\nIncidence matrix:");
        Printer.printMatrix(firstGraph.writeIncidenceMatrix());
        //Выводим матрицу инцидентности
        System.out.println("\nAdjacency matrix:");
        Printer.printMatrix(firstGraph.writeAdjacencyMatrix());

        //Список смежности
        System.out.println("\nAdjacency list:");
        Printer.printMatrix(firstGraph.writeAdjacencyList());
        //Список дуг
        System.out.println("\nEdges list:");
        Printer.printEdgesArray(firstGraph.writeEdges());

        //Запоминаем заданный граф и считываем его матрицу смежности
        Main.graph = firstGraph;
        Main.matrix = firstGraph.writeAdjacencyMatrix();
        htd.repaint();

        Thread.sleep(1500);

        //Добавляем новую вершину к графу
        Vertex vertex = new Vertex('Z');
        firstGraph.addVertex(vertex);
        Edge edge = new Edge(firstGraph.getVertices()[0], firstGraph.getVertices()[firstGraph.getVertices().length-1]);
        firstGraph.addEdge(edge);
        //И рисуем то, что получилось
        firstGraph.printGraph();

        //Выполняем алгоритм обхода графа в ширину без использования дополнительной памяти.
        System.out.println("\nWidth graph traversal:");
        char[] bfs = firstGraph.breadthFirstSearch(firstGraph.writeAdjacencyMatrix());
        System.out.println(bfs);

        //Теперь раскраска графа. Используется т.н. "жадный" алгоритм с коэффициентами.
        System.out.println("\nGraph coloring:");
        firstGraph.greedyColoring(firstGraph.writeAdjacencyList());

        Main.graph = firstGraph;
        Main.matrix = firstGraph.writeAdjacencyMatrix();

        htd.repaint();
    }
}
