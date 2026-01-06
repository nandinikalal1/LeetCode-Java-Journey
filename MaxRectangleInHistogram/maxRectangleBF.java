// Class: Solves the Largest Rectangle in Histogram using Brute Force method
public class maxRectangleBF {

  // Method: Calculates the largest rectangle area in a histogram using a brute force approach
// Purpose: For each bar, it checks how wide a rectangle can be formed using that bar’s height
// Logic: It expands to the left and right while the bars are greater than or equal to current bar height,
//        then calculates width and area, and keeps track of the maximum area seen so far.
// Input: int[] heights - array of bar heights
// Output: int - maximum rectangular area found using brute force
    public static int largestRectangleAreaBrute(int[] heights) {
        int n = heights.length;      // n = number of bars
        int maxArea = 0;             // To store the maximum area found

        // Loop: Go through each bar one by one (from left to right)
        for (int i = 0; i < n; i++) {
            // currentHeight = height of the bar we are currently analyzing
            int currentHeight = heights[i];

            // Step 1: Expand to the left from index i
            // Purpose: Find how many bars are taller or equal going to the left
            int left = i;
            // Keep going left while we are within the array (left > 0)
            // and while the bar to the left is at least as tall as current bar
            while (left > 0 && heights[left - 1] >= currentHeight) {
                left = left - 1; // Move one step left
            }

            // Step 2: Expand to the right from index i
            // Purpose: Find how many bars are taller or equal going to the right
            int right = i;
            // Keep going right while we are within the array
            // and the bar to the right is at least as tall as current
            while (right < n - 1 && heights[right + 1] >= currentHeight) {
                right = right + 1; // Move one step right
            }

            // Step 3: Calculate width and area
            // width = total number of bars we can include (from left to right)
            int width = right - left + 1;
            // area = height * width
            int area = currentHeight * width;

            // Step 4: Update maxArea if the new area is bigger
            if (area > maxArea) {
                maxArea = area;
            }
        }

        // Return the largest area found
        return maxArea;
    }

    // Main method: Entry point to test brute force logic
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleAreaBrute(heights);
        System.out.println("Largest Rectangle Area (Brute Force): " + result);
    }
}
