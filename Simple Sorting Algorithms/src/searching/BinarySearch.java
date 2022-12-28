package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArr = new int[]{1,2,3,4,5,7,8,9};
        
        System.out.println("Searching for " + 6 + ": " + BinarySearch.searchClosest(intArr, 6, 0, 8));
    }

    // slightly modified version of binary search
    // here if not found, the next smaller or the first value is returned
    public static int searchClosest(int[] arr, int b, int left, int right) {
        int closest = left;
        while (left <= right) {
            int middle = (left + right) / 2;

            // adjust borders
            if (arr[middle] == b) return middle;
            else if (arr[middle] > b) right = middle - 1;
            else {
                closest = middle;
                left = middle + 1;
            }
        }

        return closest;
    }
}
