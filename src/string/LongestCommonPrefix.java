package string;

/**
 * Created by liqiushi on 7/19/14.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"any men", "an apple", "annoying child"};
//        String[] strs = {"", "an apple", "annoying child"};
//        String[] strs = {"ff", "an apple", "annoying child"};
        String[] strs = {"assd"};
        System.out.print(longestCommonPrefix(strs));

    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";

        if (strs.length == 0)
            return "";

        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < min)
                min = str.length();
        }

        String result = "";
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i))
                    return result;
            }
            result += c;
        }

        return result;
    }
}
