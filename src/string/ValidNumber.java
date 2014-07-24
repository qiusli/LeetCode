package string;

/**
 * Created by liqiushi on 7/19/14.
 */
public class ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1"));
        System.out.println(isNumber("012"));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("a c"));
        System.out.println(isNumber("1 c"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("20e3"));
        System.out.println(isNumber(""));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("      "));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber(".1."));
        System.out.println(isNumber("01"));
        System.out.println(isNumber("01e"));
        System.out.println(isNumber("0001"));
        System.out.println(isNumber("3."));
        System.out.println(isNumber("-3."));
        System.out.println(isNumber("+.3"));
        System.out.println(isNumber("+3.3"));
        System.out.println(isNumber("+3+.3"));
        System.out.println(isNumber("-."));
        System.out.println(isNumber("+-."));
        System.out.println(isNumber("5.2.3"));
        System.out.println(isNumber("5e2.3"));
        System.out.println(isNumber("-e2.3"));
        System.out.println(isNumber("-3e2.3"));
        System.out.println(isNumber("-3e23"));
        System.out.println(isNumber("-92e1740e91"));
        System.out.println(isNumber("-005047e+6"));
        System.out.println(isNumber("-005047e+-6"));
        System.out.println(isNumber("-005047e-6"));
        System.out.println(isNumber("4e+"));
    }

    private static boolean isNumber(String s) {
        if (s == null)
            return false;

        if (s.length() == 0)
            return false;

        s = s.trim();

        if (s.length() == 0)
            return false;

        char[] chars = s.toCharArray();
        boolean flag = true, dotUsed = false, eUsed = false, digitUsed = false;
        for (int i = 0; i < chars.length && flag; i++) {
            if (i == 0) {
                if (Character.isDigit(chars[i])) {
                    digitUsed = true;
                }

                if (!Character.isDigit(chars[i]) && chars[i] != '+' && chars[i] != '-') {
                    flag = false;
                }

                if (chars[i] == '.') {
                    if (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                        flag = true;
                        dotUsed = true;
                    }
                }
            } else {
                if (!Character.isDigit(chars[i])) {
                    flag = false;

                    if (digitUsed && !eUsed && chars[i] == 'e') {
                        if (i + 1 < chars.length && Character.isDigit(chars[i + 1]) ||
                                i + 1 < chars.length && (chars[i + 1] == '+' || chars[i + 1] == '-')) {
                            flag = true;
                            eUsed = true;
                        }
                    }

                    if (!eUsed && chars[i] == '.' && !dotUsed) {
                        if (Character.isDigit(chars[i - 1])) {
                            flag = true;
                            dotUsed = true;
                        }

                        if ((chars[i - 1] == '+' || chars[i - 1] == '-') &&
                                i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                            flag = true;
                            dotUsed = true;
                        }
                    }

                    if ((chars[i] == '+' || chars[i] == '-') && chars[i - 1] == 'e' &&
                            i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                        flag = true;
                    }
                } else {
                    digitUsed = true;
                }
            }
        }

        return flag;
    }
}
