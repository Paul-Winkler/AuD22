import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3,7,2,5,2,3,6,34};

        // Sort the array
        SelectionSort.sort(arr);

        // Output the array
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int sorted = 0;
        int n = arr.length;

        for (; sorted < n-1; ++sorted) {
            int pos = selectMax(arr, n - 1 - sorted);

            int temp = arr[pos];
            arr[pos] = arr[n - 1 - sorted];
            arr[n - 1 - sorted] = temp;
        }
    }

    // [0, until]
    private static int selectMax(int[] arr, int until) {
        int pos = 0;

        for (int i = 0; i <= until; ++i) {
            if (arr[i] >= arr[pos]) pos = i;
        }

        return pos;
    }
}
