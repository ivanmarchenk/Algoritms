package by.bsu.mmf.algs.algorithm;

public class recursiveDichtomSearch {
    public int recursiveDichtomSearch(int[] numbers, int left, int right, int key) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == key)
                return mid;
            if(numbers[mid] < key){
                return recursiveDichtomSearch(numbers,mid + 1, right, key);
            }
            if(numbers[mid] > key){
                return recursiveDichtomSearch(numbers, left, mid - 1, key);
            }
        }
        return -1;
    }
}
