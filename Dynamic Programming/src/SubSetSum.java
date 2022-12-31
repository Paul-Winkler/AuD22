import java.util.Arrays;

public class SubSetSum {
    public static void main(String[] args) {
        // items in the set, each entry represents the value of each item
        int[] items = new int[]{2,3,1};

        double ratio = 0.5;
        
        System.out.println(String.format("A split with ratio %f is%s possible", ratio, isSubsetPossible(items, ratio) ? "": " not"));
    }

    public static boolean isSubsetPossible(int[] items, double ratio) {
        // check if split is possible
        int sum = 0;
        for (int item : items) sum += item;
        assert((sum*ratio) % 1 == 0);

        // calculate the target value z
        int z = (int) (sum * ratio);

        // create dp-table
        // i = index of the element
        // j = sum that should be achieved
        boolean[][] table = new boolean[items.length+1][z+1];
        // set base values: value of zero can be achieved only by zero elements
        table[0][0] = true; 

        // inductive step
        // System.out.println(Arrays.toString(table[0]));
        for (int i = 0; i < items.length; ++i) {
            for (int j = 0; j < z+1; ++j) {
                if (items[i] > j) {
                    // item cannot be used to achive this sum
                    table[i+1][j] = table[i][j];
                } else {
                    table[i+1][j] = table[i][j] || table[i][j-items[i]];
                }
            }
            // System.out.println(Arrays.toString(table[i+1]));
        }

        return table[items.length-1][z];
    }
}
