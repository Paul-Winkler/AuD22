import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,134,123,435,3,2,42,34,12,34124,423,2342,1};

        Quicksort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int left, int right) { 
        int i = left;
        int j = right - 1;
        int p = arr[right];

        do {
            while (i < right && arr[i] < p) ++i;
            while (j > left && arr[j] > p)  --j;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);

        arr[right] = arr[i];
        arr[i] = p;

        return i;
    }

    public static void sort(int[] arr) {
        Quicksort.sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int k = Quicksort.partition(arr, left, right);

        Quicksort.sort(arr, left, k-1);
        Quicksort.sort(arr, k+1, right);
    }
}
