import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String A = "Katze";
        String B = "Katze";

        int length = calc(A, B);

        System.out.println("Length is: " + length);
    }

    public static int calc(String A, String B) {
        // creating the dp table
        // each entry is the count of the lcs to this point
        int[][] table = new int[A.length()+1][B.length()+1];
        // no default value necessary

        // inductive step
        for (int i = 1; i < A.length()+1; ++i) {
            for (int j = 1; j < B.length()+1; ++j) {
                // if both are the same character
                int delta = A.charAt(i-1) == B.charAt(j-1) ? 1 : 0;

                int opt1 = table[i-1][j-1] + delta; // use both character
                int opt2 = table[i][j-1]; // use only B's character
                int opt3 = table[i-1][j]; // use only A's character

                table[i][j] = Math.max(opt1, Math.max(opt2, opt3));
            }

            // uncomment to see table
            System.out.println(Arrays.toString(table[i]));
        }

        return table[A.length()][B.length()];
    }
}
