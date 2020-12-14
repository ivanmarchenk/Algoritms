package by.bsu.mmf.algs.functions;

public class arrayCreator {
    public int[] createArray(int size){
        int[] array = new int[size];
        return array;
    }

    public int[] createRandomArray(int start, int end, int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()* (end - start)) + start;
        }
        return array;
    }

    public int[] factoryArray(String[] values){
        int[] result = new int[values.length];
        for (int i = 0; i < values.length ; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return  result;
    }
}
