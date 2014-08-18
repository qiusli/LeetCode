package divideandconquer;

/**
 * Created by liqiushi on 8/13/14.
 * http://www.programcreek.com/2012/12/leetcode-powx-n/
 */
public class Pow {
    public static void main(String... args) {
        System.out.println(pow(2, 3));
    }

    private static double pow(double x, int n) {
        if (n < 0) {
            return 1 / p(x, -n);
        } else {
            return p(x, n);
        }
    }

    private static double p(double x, int n) {
        if (n == 0)
            return 1;

        // 2的4次方等于两个2的2次方，如果次方为奇数，则为两个c再乘以一个自身
        double c = p(x, n / 2);
        if (n % 2 == 0) {
            return c * c;
        } else {
            return c * c * x;
        }
    }
}
