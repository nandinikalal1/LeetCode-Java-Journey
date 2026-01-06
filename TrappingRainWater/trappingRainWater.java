public class trappingRainWater {

    // Main logic to compute trapped water
    public int trap(int[] height) {

        // Edge case: if array is empty or null
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;

        // Arrays to store the maximum height to the left and right of each bar
        int[] left_max = new int[n];
        int[] right_max = new int[n];

        // Fill left_max: for each position, store the tallest bar seen from the left
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }

        // Fill right_max: for each position, store the tallest bar seen from the right
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        // Total trapped water calculation
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water at position i is limited by the shorter of the two tallest bars around it
            totalWater += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return totalWater;
    }

    // Testing the solution
    public static void main(String[] args) {

        trappingRainWater solution = new trappingRainWater();

        // Example input: heights of bars
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        // Output: total trapped water
        int result = solution.trap(height);

        System.out.println("Total trapped water: " + result);
    }
}
