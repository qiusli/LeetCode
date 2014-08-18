package divideandconquer;

/**
 * Created by liqiushi on 8/14/14.
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(10000));
        System.out.println(sqrt(2));
    }

    private static int sqrt(int x) {
        long low = 0, high = x / 2 + 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long tmp = mid * mid;

            if (tmp == (long) x) {
                return (int) mid;
            } else if (tmp > (long) x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) high;
    }
}
