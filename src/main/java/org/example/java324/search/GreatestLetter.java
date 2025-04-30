package org.example.java324.search;

public class GreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'b','d','e'};
        int k = 1;
        System.out.println(nextGreatestLetter(letters, 'f'));

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                right = mid;
                System.out.println(mid);
            } else {
                left = mid + 1;
            }
        }
        if (left == letters.length){
            return letters[0];
        } else {
            return letters[left];
        }
    }

    public static int findUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
