import java.util.Arrays;
package nthTribonocci;

public class nthTribonocci {


  //memoization
    private static int tribonacci(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = tribonacci(n - 1, dp)
              + tribonacci(n - 2, dp)
              + tribonacci(n - 3, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = tribonacci(n, dp);
        System.out.println(result);
    }
}

