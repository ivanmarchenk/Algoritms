package by.bsu.algs.algorithm;

public class algorithm {
    public String dichotomousSearch(int[] numbers, int key){
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right)/2;
            if(numbers[mid] == key){
                return "Key " + key + " belongs to the number " + mid;
            }
            if(numbers[mid] < key){
                left = mid + 1;
            }
            if(numbers[mid] > key){
                right = mid -1;
            }
        }
        return "There is no such key " + key;
    }
}
