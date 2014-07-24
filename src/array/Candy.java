package array;

/**
 * Created by liqiushi on 7/6/14.
 * http://zhaohongze.com/wordpress/2013/12/10/leetcode-candy/
 */
public class Candy {
    public static void main(String[] args) {
//        int[] ratings = {1, 1, 3, 2, 1, 4, 2, 3, 2, 4, 1};
        int[] ratings = {2, 3};
        System.out.print(candy(ratings));
    }

    private static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++)
            candies[i] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }

        int total = 0;
        for (int candy : candies)
            total += candy;

        return total;
    }
}
