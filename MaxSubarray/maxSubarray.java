// 53. Maximum Subarray (Kadane's Algorithm)


public class maxSubarray {

    // Method to find maximum subarray sum
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0]; // stores the best (maximum) sum found so far
        int curSum = nums[0]; // stores current running sum

        // Start loop from index 1 because nums[0] is already used
        for (int i = 1; i < nums.length; i++) {

            // Either start new subarray at current element
            // or continue the existing subarray
            curSum = Math.max(nums[i], curSum + nums[i]);

            // Update global max if current is larger
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    // Main method to test code
    public static void main(String[] args) {

        maxSubarray solution = new maxSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
