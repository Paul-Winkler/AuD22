public class BinarySearch {
    public static void main(String[] args) {
        int[] intArr = new int[]{1,2,3,4,5,7,8,9};
        
        System.out.println("Searching for " + 0 + ": " + BinarySearch.searchRecursive(intArr, 0));
        System.out.println("Searching for " + 1 + ": " + BinarySearch.searchRecursive(intArr, 1));
        System.out.println("Searching for " + 5 + ": " + BinarySearch.searchRecursive(intArr, 5));
        System.out.println("Searching for " + 6 + ": " + BinarySearch.searchRecursive(intArr, 6));
        System.out.println("Searching for " + 9 + ": " + BinarySearch.searchRecursive(intArr, 9));
        System.out.println("Searching for " + 10 + ": " + BinarySearch.searchRecursive(intArr, 10));
        System.out.println();
        System.out.println("Searching for " + 0 + ": " + BinarySearch.searchIterative(intArr, 0));
        System.out.println("Searching for " + 1 + ": " + BinarySearch.searchIterative(intArr, 1));
        System.out.println("Searching for " + 5 + ": " + BinarySearch.searchIterative(intArr, 5));
        System.out.println("Searching for " + 6 + ": " + BinarySearch.searchIterative(intArr, 6));
        System.out.println("Searching for " + 9 + ": " + BinarySearch.searchIterative(intArr, 9));
        System.out.println("Searching for " + 10 + ": " + BinarySearch.searchIterative(intArr, 10));
    }

    public static int searchRecursive(int[] arr, int b) {
        return BinarySearch.searchRecursive(arr, b, 0, arr.length -1);
    }

    // [left, right]
    public static int searchRecursive(int[] arr, int b, int left, int right) {
        // checking preconditions
        assert(arr.length > 0);

        // base case
        if (left > right) return -1;

        // recursive calls
        // generate middle
        int middle = (left + right) / 2;
        // System.out.println(middle);
        
        // adjust borders and make recursive calls
        if (arr[middle] == b) return middle;
        else if (arr[middle] > b) return searchRecursive(arr, b, left, middle-1);
        else return searchRecursive(arr, b, middle+1, right);
    }

    public static int searchIterative(int[] arr, int b) {
        // create position
        int left = 0;
        int right = arr.length - 1;

        // iterate over array
        while (left <= right) {
            int middle = (left + right) / 2;

            // adjust borders
            if (arr[middle] == b) return middle;
            else if (arr[middle] > b) right = middle - 1;
            else left = middle + 1;
        }

        // return if not found
        return -1;
    }
}
