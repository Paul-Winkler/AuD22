import java.util.Arrays;

public class EditingDistance {
    public static void main(String[] args) {
        String A = "Tiger";
        String B = "Ziege";

        int length = calcCosts(A, B);

        System.out.println("Cost is: " + length);
    }

    public static int calcCosts(String A, String B) {
        // creating dp-table
        // each entry stands for the minimal costs to reach this point
        int[][] table = new int[A.length()+1][B.length()+1];
        // no base cases needed

        // inductive steps
        System.out.println("   " + Arrays.toString((" "+B).toCharArray()));
        System.out.println(" : " + Arrays.toString(table[0]));
        for (int i = 1; i < A.length()+1; ++i) {
            for (int j = 1; j < B.length()+1; ++j) {
                // select both, if unequal add replacement cost
                int opt1 = table[i-1][j-1] + (A.charAt(i-1) == B.charAt(j-1) ? 0 : 1);
                // insert in A/ B
                int opt2 = table[i-1][j] + 1;
                int opt3 = table[i][j-1] + 1;

                table[i][j] = Math.min(opt1, Math.min(opt2, opt3));
            }

            // uncomment to see table
            System.out.println((" "+A).charAt(i) + ": " + Arrays.toString(table[i]));
        }

        return table[A.length()][B.length()];
    }
}
