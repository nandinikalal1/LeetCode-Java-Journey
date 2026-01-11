//Problem: You are given a matrix of 0s and 1s
//You must find the largest rectangle made only of 1s and return it's area

// Approach: Convert each matrix row into a "histogram of heights" of consecutive 1s,
// then for each row compute Largest Rectangle in Histogram using a monotonic stack.
/* 1011
   1111 - we build heights row by row. 
   Row 1 heights-> [1,0,1,1]
   Row 2 Heights -> [2,1,2,2] 
   For each row, we find the largest rectangle in the rectangle*/

import java.util.*;

public class MaximalRectangle {

    // Main function asked by LeetCode
    public int maximalRectangle(char[][] matrix) {
        // Edge case: empty matrix or no rows or no columns
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        //store matrix dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;

        // heights[c] = how many consecutive '1's are stacked vertically up to current row at column c
        int[] heights = new int[cols];
//each index represents how many continous 1s vertically in that column
        int best = 0; //Store max rectangle area found

        // Loop: Build histogram row by row, one row at a time
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If current cell is '1', increase height; else reset height to 0. if cell is '0' -> reset height
                if (matrix[r][c] == '1') heights[c] += 1;
                else heights[c] = 0;
            }

            // For this row's histogram, compute largest rectangle area
            best = Math.max(best, largestRectangleArea(heights)); //reuse histogram logic
        }

        return best;
    }

    // Standard Largest Rectangle in Histogram using monotonic increasing stack of indices
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int best = 0;

        // Stack will store indices, and heights at those indices will be increasing
        Deque<Integer> stack = new ArrayDeque<>();

        // We iterate to n (inclusive) using a "sentinel" or imaginary height = 0 at the end
        // This forces remaining bars in stack to be popped and processed.
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            // If current height is smaller, we found the right boundary for taller bars
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
// width = distance between smaller bars
                // After popping, stack.peek() is the index of the previous smaller bar (left boundary)
                int leftSmallerIndex = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftSmallerIndex - 1;

                best = Math.max(best, h * width);
            } 

            stack.push(i);
        }

        return best;
    }

    // --------- Simple test runner ----------
    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();

        char[][] matrix1 = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(sol.maximalRectangle(matrix1)); // Expected: 6

        char[][] matrix2 = {
                {'0'}
        };
        System.out.println(sol.maximalRectangle(matrix2)); // Expected: 0

        char[][] matrix3 = {
                {'1'}
        };
        System.out.println(sol.maximalRectangle(matrix3)); // Expected: 1
    }
}
