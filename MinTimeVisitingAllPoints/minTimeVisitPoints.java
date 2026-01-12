package MinTimeVisitingAllPoints;

/*
    Problem idea (simple):
    - You are given a list of points on a 2D plane.
    - You must visit them in the same order as given.
    - In 1 second, you can move:
        1) 1 step horizontally (x changes by 1)
        2) 1 step vertically   (y changes by 1)
        3) 1 step diagonally   (x changes by 1 AND y changes by 1 in the same second)

    Key observation (most important concept):
    - Between two points (x1, y1) -> (x2, y2)
        dx = |x2 - x1|  (how far in x direction)
        dy = |y2 - y1|  (how far in y direction)

    - Each diagonal move reduces BOTH dx and dy by 1 in one second.
      So we should use diagonal moves as much as possible.

    - After using diagonals, the remaining distance is only in one direction.

    Result:
    - Minimum time to go from one point to the next = max(dx, dy)

    Then:
    - Total minimum time = sum of max(dx, dy) for each consecutive pair of points.
*/

public class minTimeVisitPoints {

    /**
     * Returns the minimum time to visit all points in the given order.
     * points[i] = {xi, yi}
     * return minimum time in seconds
     */
    public static int minTimeToVisitAllPoints(int[][] points) {
        // If there are 0 or 1 points, no movement needed.
        if (points == null || points.length <= 1) {
            return 0;
        }

        int totalTime = 0;

        // We move from points[0] -> points[1] -> points[2] -> ...
        for (int i = 0; i < points.length - 1; i++) {
            totalTime += timeBetween(points[i], points[i + 1]);
        }

        return totalTime;
    }

    /**
     * Calculates minimum time to move from point A to point B.
     * Why max(dx, dy)?
     * - In one second, diagonal move can reduce both dx and dy together.
     * - So the slower (bigger) distance decides the total seconds.
     */
    private static int timeBetween(int[] a, int[] b) {
        int dx = Math.abs(b[0] - a[0]); // horizontal distance
        int dy = Math.abs(b[1] - a[1]); // vertical distance
        return Math.max(dx, dy);
    }
     //Helper method: prints a 2D points array nicely for testing.
    private static void printPoints(int[][] points) {
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            System.out.print("[" + points[i][0] + "," + points[i][1] + "]");
            if (i < points.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    //Main method to test with example inputs (you can change points anytime).
    public static void main(String[] args) {
        // Example 1
        int[][] points1 = { {1, 1}, {3, 4}, {-1, 0} };
        int result1 = minTimeToVisitAllPoints(points1);

        System.out.print("Input points = ");
        printPoints(points1);
        System.out.println("Minimum time = " + result1);
        System.out.println("Expected = 7");
        System.out.println();

        // Example 2
        int[][] points2 = { {3, 2}, {-2, 2} };
        int result2 = minTimeToVisitAllPoints(points2);

        System.out.print("Input points = ");
        printPoints(points2);
        System.out.println("Minimum time = " + result2);
        System.out.println("Expected = 5");
        System.out.println();

        // Custom test (edit values to test more cases)
        int[][] points3 = { {0, 0}, {2, 2}, {2, 5}, {10, 6} };
        int result3 = minTimeToVisitAllPoints(points3);

        System.out.print("Input points = ");
        printPoints(points3);
        System.out.println("Minimum time = " + result3);
    }
}
