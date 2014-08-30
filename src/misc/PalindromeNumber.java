package misc;

/**
 * Created by liqiushi on 8/28/14.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1232));
        System.out.println(isPalindrome(111121111));
        System.out.println(Integer.MIN_VALUE);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int[] tmp = new int[1];
        tmp[0] = x;
        return isPalindrome(x, tmp);
    }

    private static boolean isPalindrome(int x, int[] x1) {
        if (x == 0)
            return true;

        if (isPalindrome(x / 10, x1) && (x % 10 == x1[0] % 10)) {
            x1[0] /= 10;
            return true;
        } else {
            return false;
        }
    }
}
