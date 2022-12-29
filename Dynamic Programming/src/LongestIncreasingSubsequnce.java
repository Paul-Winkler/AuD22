import searching.BinarySearch;

public class LongestIncreasingSubsequnce {
    public static void main(String[] args) {
        int[] testArr = new int[]{2,1,2,4,5,3,4,5,6,10,7,20};

        System.out.println("TestArr's liss is " + LongestIncreasingSubsequnce.find(testArr));
    }

    public static String find(int[] arr) {
        // DP-Table
        // contains the last element of iss with length i
        int[] table = new int[arr.length+1];
        table[0] = Integer.MIN_VALUE;

        int[] predecessor = new int[arr.length+1];
        predecessor[0] = -1;
        
        for (int i = 1; i < table.length; ++i) {
            table[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        int maxPosition = 0;

        for (int i = 0; i < arr.length; ++i) {
            int element = arr[i];

            // get longest iss which can be extended by the new element
            int position = BinarySearch.searchClosest(table, element, 0, arr.length-1);

            // update greatest position
            maxPosition = Math.max(maxPosition, position+1);

            // update dp-table
            table[position+1] = element;
            // updating predecessor
            predecessor[position+1] = table[position];
        }

        // construct liss
        String liss = "";
        for (int i = maxPosition; i > 0;) {
            liss += table[i] +", ";

            if (predecessor[i] != -1) i = BinarySearch.searchClosest(table, predecessor[i], 0, i);
            else break;
        }
        
        return liss;
    }
}
