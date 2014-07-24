package string;

/**
 * Created by liqiushi on 7/19/14.
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    private static String countAndSay(int n) {
        String result = "1";
        while (n > 1) {
            String t_r = "";
            for (int i = 0; i < result.length(); ) {
                int counter = 1;
                if (i + 1 < result.length()) {
                    while (i + 1 < result.length() && result.charAt(i + 1) == result.charAt(i)) {
                        counter++;
                        i++;
                    }
                }
                t_r += String.valueOf(counter) + result.charAt(i);
                i++;
            }
            result = t_r;
            n--;
        }

        return result;
    }
}
