import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,134,123,435,3,2,42,34,12,34124,423,2342,1};

        HeapSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    // beautiful sorting in O(n log n)
    public static void sort(int[] arr) {
        MaxHeap heap = new MaxHeap(arr);

        for (int i = arr.length-1; i >= 0; --i) {
            arr[i] = heap.extractMax();
        }
    }
}
