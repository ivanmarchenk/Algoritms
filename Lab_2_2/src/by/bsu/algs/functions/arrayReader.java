package by.bsu.algs.functions;

import java.io.InputStream;
import java.util.Scanner;

public class arrayReader {
    public static final String SEPARATOR = "\\s+";

    public String[] readStringArray(InputStream input){
        Scanner scan = new Scanner(input);
        String line = scan.nextLine();
        line = line.trim();
        String[] numbers = line.split(SEPARATOR);
        return numbers;
    }

    public int readIntegerNumber(InputStream input){
        Scanner scan = new Scanner(input);
        return scan.nextInt();
    }
}
