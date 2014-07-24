package string;

/**
 * Created by liqiushi on 7/12/14.
 */
public class StringToInteger {
    public static void main(String[] args) {
//        System.out.print(atoi("  -0012a42"));
        System.out.print(atoi(" b11228552307"));
    }

    private static int atoi(String str) {
        if (str == null)
            return 0;

        if (str.equals(""))
            return 0;

        String new_str = "";
        String op = "";
        boolean op_found = false, num_found = false;

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (!num_found && tmp != 32) {
                if (tmp < 48 || tmp > 57) {
                    if (tmp != 43) {
                        if (tmp != 45)
                            return 0;
                    }
                }

                if (tmp == 43 || tmp == 45) {
                    if (!op_found &&
                            i < str.length() &&
                            (str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57)) {
                        op_found = true;
                        op = String.valueOf(tmp);
                    } else {
                        return 0;
                    }
                }
            }

            if (tmp >= 48 && tmp <= 57) {
                if (!num_found) {
                    num_found = true;
                }
                new_str += tmp;
            } else {
                if (num_found)
                    break;
            }
        }

        long num = 0l;
        long multiplier = 1;
        if (!new_str.equals("")) {
            int counter = new_str.length() - 1;
            while (counter >= 0) {
                num += Integer.valueOf(String.valueOf(new_str.charAt(counter--))) * multiplier;
                multiplier *= 10;
            }
        }

        if (op.equals("-"))
            num = -num;

        if (num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) num;
    }
}
