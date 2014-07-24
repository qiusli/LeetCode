package string;

/**
 * Created by liqiushi on 7/12/14.
 */
public class MyStrStr {
    public static void main(String[] args) {
//        String haystack = "this is a test";
        System.out.print(strStr("a", ""));
    }

    private static String strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return null;

        if (needle.length() > haystack.length())
            return null;

        if (needle.equals(""))
            return haystack;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return haystack.substring(i);
            }
        }

        return null;
    }
}
