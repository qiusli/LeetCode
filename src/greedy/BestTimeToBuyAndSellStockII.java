package greedy;

/**
 * Created by liqiushi on 8/17/14.
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {3, 5, 1, 2, 6, 5, 9, 8};
        System.out.println(maxProfit(prices));

        int[] prices2 = {4, 1, 2};
        System.out.println(maxProfit(prices2));

        int[] prices3 = {2, 1, 2};
        System.out.println(maxProfit(prices3));

        int[] prices4 = {5, 4, 3};
        System.out.println(maxProfit(prices4));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // down
            while (i + 1 < prices.length && prices[i + 1] <= prices[i])
                i++;

            int low = i;

            // up
            while (i + 1 < prices.length && prices[i + 1] >= prices[i])
                i++;

            profit += prices[i] - prices[low];
        }

        return profit;
    }
}
