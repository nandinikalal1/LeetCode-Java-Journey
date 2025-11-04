import java.util.Stack;

// Class: Solves the Largest Rectangle in Histogram using Stack (Optimized)
public class maxRectangleStack {

// Method: Calculates the largest rectangle area in a histogram using an optimized stack-based approach
// Purpose: Instead of checking all bars for each index, it uses a stack to efficiently track increasing bars,
//          and only calculates area when a shorter bar is found (monotonic stack logic).
// Logic: The stack stores indices of increasing height bars.
//        When a shorter bar is found, the top index is popped and width is calculated based on distance to previous bar.
//        This allows each bar to be processed only once for area calculation.
// Input: int[] heights - array of bar heights
// Output: int - maximum rectangular area found using the optimized stack method
    public static int largestRectangleAreaOptimized(int[] heights) {
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of bars
        int maxArea = 0;                       // Keeps track of largest rectangle area found
        int n = heights.length;                // Total number of bars

        int i = 0; // i is the index we'll use to walk through the histogram

        // Loop: Go from i = 0 to i = n (we also process one extra index to flush the stack)
        while (i <= n) {

            // Step 1: Get current bar height
            // When i == n, we pretend there's a bar of height 0 to flush remaining stack
            int currentHeight;
            if (i == n) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            // Step 2: If the stack is empty OR current bar is taller or equal to the top bar in stack
            if (stack.isEmpty() || currentHeight >= heights[stack.peek()]) {
                // Explanation: We are still seeing increasing height pattern, so push this index
                stack.push(i); // Add this bar's index to the stack
                i = i + 1;     // Move to next bar
            } else {
                // Step 3: Current bar is shorter → we need to calculate area for taller bars

                // Pop the top index (we'll calculate area for this bar height)
                int topIndex = stack.pop();

                // height of the rectangle = height of the bar at popped index
                int height = heights[topIndex];

                // Calculate width:
                // If stack is empty after popping, this bar spans from 0 to current i
                // If not empty, it spans between stack.peek() and i (excluding both ends)
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                // Calculate area = height × width
                int area = height * width;

                // Update maxArea if this area is bigger
                if (area > maxArea) {
                    maxArea = area;
                }

                // Important: We do not increment i here — we stay at same index
                // Because we might need to process more rectangles before moving forward
            }
        }

        // Return the largest rectangle area found
        return maxArea;
    }

    // Main method: Entry point to test the optimized solution
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleAreaOptimized(heights);
        System.out.println("Largest Rectangle Area (Optimized): " + result);
    }
}
