public class InterpolationSearch {
    public static void main(String[] args) {
        int[] intArr = new int[]{1,2,3,4,5,7,8,9};
        
        System.out.println("Searching for " + 0 + ": " + InterpolationSearch.searchIterative(intArr, 0));
        System.out.println("Searching for " + 1 + ": " + InterpolationSearch.searchIterative(intArr, 1));
        System.out.println("Searching for " + 5 + ": " + InterpolationSearch.searchIterative(intArr, 5));
        System.out.println("Searching for " + 6 + ": " + InterpolationSearch.searchIterative(intArr, 6));
        System.out.println("Searching for " + 9 + ": " + InterpolationSearch.searchIterative(intArr, 9));
        System.out.println("Searching for " + 10 + ": " + InterpolationSearch.searchIterative(intArr, 10));
    }

    public static int searchIterative(int[] arr, int b) {
        // create position
        int left = 0;
        int right = arr.length - 1;

        // iterate over array
        while (left <= right) {
            double roh = (b - arr[left]) / (arr[right] - arr[left]);

            int middle = (int) Math.floor(left + (right - left) * roh);

            // adjust borders
            if (arr[middle] == b) return middle;
            else if (arr[middle] > b) right = middle - 1;
            else left = middle + 1;
        }

        // return if not found
        return -1;
    }
}
