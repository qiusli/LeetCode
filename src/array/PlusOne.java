package array;

/**
 * Created by liqiushi on 7/4/14.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {5, 4, 2, 9};
        int[] result = plusOne(digits);
        for (int i : result)
            System.out.print(i);
    }

    private static int[] plusOne(int[] digits) {
        if (digits == null)
            return null;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            for (int i = 1; i < tmp.length; i++)
                tmp[i] = 0;

            return tmp;
        }
        return digits;
    }
}
