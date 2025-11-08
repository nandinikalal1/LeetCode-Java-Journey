// 11. Container With Most Water
// Time Complexity: O(n)
// Space Complexity: O(1)

public class containerWithMostWater {

    // This method calculates the maximum water that can be trapped
    public int maxArea(int[] height) {

        int maxWater = 0; // stores maximum water area
        int left = 0; // pointer at the start
        int right = height.length - 1; // pointer at the end

        // Move pointers towards each other until they meet
        while (left < right) {
            // Minimum of the two heights determines water level
            int ht = Math.min(height[left], height[right]);

            // Width between the two lines
            int width = right - left;

            // Area of water between them
            int currWater = ht * width;

            // Update maximum if current is larger
            maxWater = Math.max(maxWater, currWater);

            // Move pointer pointing to smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    // Main method for testing 
    public static void main(String[] args) {
        containerWithMostWater solution = new containerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water area: " + solution.maxArea(height));
    }
}
