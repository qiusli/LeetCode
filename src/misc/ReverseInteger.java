package misc;

/**
 * Created by liqiushi on 8/28/14.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
    }

    private static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }

        String s = String.valueOf(x);
        int multiplier = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += Integer.valueOf(String.valueOf(s.charAt(i))) * multiplier;
            multiplier *= 10;
        }

        return !flag ? result : -result;
    }
}
