package string;

/**
 * Created by liqiushi on 7/13/14.
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "";
        String b = "";
        System.out.print(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        String result = "";

        boolean carry_over = false;
        int l_a = a.length() - 1, l_b = b.length() - 1;
        while (l_a >= 0 && l_b >= 0) {
            if (a.charAt(l_a) == '1' && b.charAt(l_b) == '1') {
                if (carry_over) {
                    result = 1 + result;
                } else {
                    result = 0 + result;
                }
                carry_over = true;
            } else {
                if (a.charAt(l_a) == '1' || b.charAt(l_b) == '1') {
                    if (carry_over) {
                        result = 0 + result;
                        carry_over = true;
                    } else {
                        result = 1 + result;
                        carry_over = false;
                    }
                } else {
                    result = carry_over ? 1 + result : 0 + result;
                    carry_over = false;
                }
            }
            l_a--;
            l_b--;
        }

        while (l_a >= 0) {
            if (carry_over) {
                if (a.charAt(l_a) == '1') {
                    carry_over = true;
                    result = 0 + result;
                } else {
                    carry_over = false;
                    result = 1 + result;
                }
            } else {
                result = a.charAt(l_a) + result;
            }
            l_a--;
        }

        while (l_b >= 0) {
            if (carry_over) {
                if (b.charAt(l_b) == '1') {
                    carry_over = true;
                    result = 0 + result;
                } else {
                    carry_over = false;
                    result = 1 + result;
                }
            } else {
                result = b.charAt(l_b) + result;
            }
            l_b--;
        }

        if (carry_over)
            result = 1 + result;

        return result;
    }
}
