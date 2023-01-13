import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,13,6,124,123,5,23,1,3,52,34,123,0,451, 122};
        int[] cpArr = arr.clone();

        MergeSort.sortRecursive(arr);
        MergeSort.sortIterative(cpArr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(cpArr));
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int[] tempArr = new int[right-left+1];

        int i = left;
        int j = middle + 1;
        int k = 0;

        // merge both into one
        while (i <= middle && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k] = arr[i];
                ++i;
            } else {
                tempArr[k] = arr[j];
                ++j;
            }
            ++k;
        }

        // append the rest
        while (i <= middle) {
            tempArr[k] = arr[i];
            ++i;
            ++k;
        }

        while (j <= right) {
            tempArr[k] = arr[j];
            ++j;
            ++k;
        }

        // updating original array
        for (int l = 0; l < tempArr.length; ++l) {
            arr[left + l] = tempArr[l];
        }
    }

    public static void sortRecursive(int[] arr) {
        MergeSort.sortRecursive(arr, 0, arr.length - 1);
    }

    private static void sortRecursive(int[] arr, int left, int right) {
        if (left == right) return;

        // selecting the middle
        int middle = (left + right) / 2;
        
        // making recursive calls
        MergeSort.sortRecursive(arr, left, middle);
        MergeSort.sortRecursive(arr, middle + 1, right);
        // subproblems are now sorted

        // merge sorted subproblems
        MergeSort.merge(arr, left, middle, right);
    }

    public static void sortIterative(int[] arr) {
        // length of subproblem
        int length = 1;

        // calculating each subproblem
        while (length < arr.length) { 
            int right = -1;

            // applying merge sort
            while (right + length < arr.length) {
                int left = right + 1;
                int middle = left + length - 1;
                right = Math.min(arr.length - 1, middle + length);

                MergeSort.merge(arr, left, middle, right);
            }

            // increase subproblem size
            length *= 2;
        }
    }
}
