import java.util.Arrays;  
public class fibonacciNumber {

    // memo[i] will store the calculated Fibonacci result for i
    private int[] memo;

    // Main method that will be called by LeetCode
    public int fib(int n) {

        // Create memo array of size n+1
        memo = new int[n + 1];

        // Fill memo array with -1 to mark values as uncalculated
        Arrays.fill(memo, -1);

        // Call helper function
        return helper(n);
    }

    // Helper function to calculate Fibonacci using recursion + memoization
    private int helper(int n) {

        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // If already calculated, return stored value
        if (memo[n] != -1) {
            return memo[n];
        }

        // Otherwise calculate and store in memo
        memo[n] = helper(n - 1) + helper(n - 2);

        return memo[n];
    }

    // Main method for testing locally
    public static void main(String[] args) {

        fibonacciNumber solution = new fibonacciNumber();

        int result = solution.fib(10);  // Example test

        System.out.println("Fibonacci(10): " + result);
    }
}
