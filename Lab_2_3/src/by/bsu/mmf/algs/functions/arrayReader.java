package by.bsu.mmf.algs.functions;

import java.io.InputStream;
import java.util.Scanner;

public class arrayReader {
    public int reader(InputStream input){
        Scanner scan = new Scanner(input);
        return scan.nextInt();
    }
}
