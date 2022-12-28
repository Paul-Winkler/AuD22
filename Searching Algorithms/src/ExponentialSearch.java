public class ExponentialSearch {
    public static void main(String[] args) {
        int[] intArr = new int[]{1,2,3,4,5,7,8,9};
        
        System.out.println("Searching for " + 0 + ": " + ExponentialSearch.searchRecursive(intArr, 0));
        System.out.println("Searching for " + 1 + ": " + ExponentialSearch.searchRecursive(intArr, 1));
        System.out.println("Searching for " + 5 + ": " + ExponentialSearch.searchRecursive(intArr, 5));
        System.out.println("Searching for " + 6 + ": " + ExponentialSearch.searchRecursive(intArr, 6));
        System.out.println("Searching for " + 9 + ": " + ExponentialSearch.searchRecursive(intArr, 9));
        System.out.println("Searching for " + 10 + ": " + ExponentialSearch.searchRecursive(intArr, 10));
    }

    public static int searchRecursive(int[] arr, int b) {
        int r = 1;

        while (r < arr.length && b > arr[r]) r *= 2;

        return BinarySearch.searchRecursive(arr, b, 0, Math.min(r, arr.length - 1));
    }
}
