package greedy;

/**
 * Created by liqiushi on 8/16/14.
 */
public class BestTimeToBuyAndSellStock {
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

        int min = Integer.MAX_VALUE, max_diff = 0;
        for (int price : prices) {
            // 始终找出当前value之前的最小值与当前值比较
            if (price < min)
                min = price;

            if (price - min > max_diff)
                max_diff = price - min;
        }

        return max_diff;
    }
}
