package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/11/14.
 */
public class RemoteIPAddresses {
    public static void main(String[] args) {
//        List<String> res1 = restoreIpAddresses("25525511135");
//        List<String> res1 = restoreIpAddresses("1111");
        List<String> res1 = restoreIpAddresses("3212131232");
        for (String s : res1) {
            System.out.print(s);
            System.out.println();
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.trim().length() == 0)
            return res;

        int separatorPut = 0;
        List<String> subs = new ArrayList<String>();
        backTrack(separatorPut, s, subs, res);
        return res;
    }

    private static void backTrack(int separatorPut, String str, List<String> subs,
                                  List<String> res) {
        if (separatorPut >= 3) {
            subs.add(str);
            if (isValidSub(str)) {
                String tmp = "";
                for (String s : subs) {
                    tmp += s + ".";
                }
                res.add(tmp.substring(0, tmp.length() - 1));
            }
            subs.remove(subs.size() - 1);
            return;
        }

        for (int i = 1; i < 4 && i <= str.length(); i++) {
            String sub = str.substring(0, i);
            if (isValidSub(sub)) {
                subs.add(sub);
                backTrack(separatorPut + 1, str.substring(i), subs, res);
                // should not use subs.remove(sub) here as may exists duplicate ones before
                subs.remove(subs.size() - 1);
            }
        }
    }

    private static boolean isValidSub(String s) {
        // empty string
        if (s.length() == 0)
            return false;

        // starts with 0
        if (s.length() > 1 && Integer.valueOf(String.valueOf(s.charAt(0))) == 0)
            return false;

        // length larger than 3
        if (s.length() > 3)
            return false;

        // calculate sub value
        int multiplier = 1, sum = 0, i = s.length() - 1;
        while (i >= 0) {
            sum += Integer.valueOf(String.valueOf(s.charAt(i))) * multiplier;
            multiplier *= 10;
            i--;
        }

        return sum <= 255;
    }
}
