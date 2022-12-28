import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,12,5,6,7,8,9};

        MaxHeap heap = new MaxHeap(arr);

        System.out.println(Arrays.toString(heap.structure));

        for (int i = 0; i < arr.length; ++i) System.out.println("t: " + heap.extractMax());
    }

    // contains all heap elements
    // INV: max-heap-condition is fulfilled
    public int[] structure;
    private int length;

    public MaxHeap(int[] arr) {
        this.structure = new int[arr.length];
        this.length = arr.length;

        // generate a local copy of the array
        for (int i = 0; i < this.length; ++i) this.structure[i] = arr[i];

        // create the real heap
        for (int i = this.length / 2; i >= 0; --i) this.restoreHeapCondition(i);
    }

    public int extractMax() {
        int max = this.structure[0];

        // swap elements
        this.structure[0] = this.structure[this.length-1];
        this.length--;

        this.restoreHeapCondition(0);

        return max;
    }

    private void restoreHeapCondition(int i) {
        ++i; // this happens, because otherwise the condition can not be checked. it affects all array accesses!

        while (2 * i <= this.length) {
            int j = 2 * i;
            
            // select greater child
            if (j+1 <= this.length && this.structure[j] > this.structure[j-1]) ++j;
            
            // compare parent and child
            if (this.structure[j-1] < this.structure[i-1]) return;
            
            // swap and repeat
            int temp = this.structure[i-1];
            this.structure[i-1] = this.structure[j-1];
            this.structure[j-1] = temp;
            
            // repeat with next child
            i = j;
        }
    }
}
