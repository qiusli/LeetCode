package greedy;

/**
 * Created by liqiushi on 8/17/14.
 * http://blog.csdn.net/pickless/article/details/12034365
 */
public class BestTimeToBuyAndSellStockIII {
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

    // this is to find a anchor at which the sum of its left side and
    // right side are the biggest, so we use 2 loops to find individually
    // the left and right biggest value at each index, the biggest sum at a
    // particular index is the result
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // left[i] means the largest profit from left[0] - left[i]
        int[] left = new int[prices.length];
        // right[i] means the largest from right[i] to right[n - 1]
        int[] right = new int[prices.length];

        // construct left
        int left_min = prices[0]; // the smallest value before the current price
        left[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            left[i] = prices[i] - left_min > left[i - 1] ? prices[i] - left_min : left[i - 1];
            left_min = prices[i] < left_min ? prices[i] : left_min;
        }

        int right_max = prices[prices.length - 1];
        right[0] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = right_max - prices[i] > right[i + 1] ? right_max - prices[i] : right[i + 1];
            right_max = prices[i] > right_max ? prices[i] : right_max;
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }
}
