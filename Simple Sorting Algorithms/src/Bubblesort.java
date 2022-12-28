import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3,7,2,5,2,3,6,34};

        // Sort the array
        Bubblesort.sort(arr);

        // Output the array
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            bubble(arr);
        }
    }

    private static void bubble(int[] arr) {
        // compare each element in its successor
        for (int i = 0; i < arr.length - 1; ++i) {
            // if wrong order, then flip
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}
