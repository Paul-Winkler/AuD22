import java.util.Arrays;

import searching.BinarySearch;

public class InsetionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3,7,2,5,2,3,6,34};

        // Sort the array
        InsetionSort.sort(arr);

        // Output the array
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int sorted = 1;
        for (; sorted < arr.length; ++sorted) {
            int pos = BinarySearch.searchClosest(arr, arr[sorted], 0, sorted-1);

            System.out.println(pos);

            shift(arr, pos, sorted);
        }
    }

    private static void shift(int[] arr, int from, int to) {
        int temp = arr[to];

        for (int i = from; i < to; ++i) arr[i+1] = arr[i];

        arr[from] = temp;
    }
}

