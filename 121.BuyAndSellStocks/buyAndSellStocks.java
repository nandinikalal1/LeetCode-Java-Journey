
public class buyAndSellStocks {

    // Method that calculates the maximum profit
    public int maxProfit(int[] prices) {

        // Track the lowest buy price and the maximum profit
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Loop through each price
        for (int i = 0; i < prices.length; i++) {

            // Update buyPrice if we find a cheaper stock
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            // Calculate profit if we sold today
            int profit = prices[i] - buyPrice;

            // Update maxProfit if today’s profit is better
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    
    public static void main(String[] args) {
        buyAndSellStocks solution = new buyAndSellStocks();

        // Test case 1: Expected 5
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Test 1): " + solution.maxProfit(prices1));

        // Test case 2: Expected 0
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit (Test 2): " + solution.maxProfit(prices2));

        // Test case 3: Expected 4
        int[] prices3 = {3, 4, 5, 7};
        System.out.println("Max Profit (Test 3): " + solution.maxProfit(prices3));
    }
}
