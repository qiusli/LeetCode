package string;

import java.util.*;

/**
 * Created by liqiushi on 7/20/14.
 */
public class Anagrams {
    public static void main(String[] args) {
//        String[] strs = {"abba", "abbc", "abcb", "aabb", "bbaa", "asddsa", ""};
        String[] strs = {"", "b"};
        List<String> result = anagrams(strs);
        for (String s : result)
            System.out.println(s);
    }

    private static List<String> anagrams(String[] strs) {
        if (strs == null)
            return null;

        List<String> result = new ArrayList<String>();
        Set<String> parent = new HashSet<String>();

        // new_old
        Map<String, String> new_old = new HashMap<String, String>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c);

            if (new_old.get(str) != null) {
                if (!parent.contains(str)) {
                    result.add(new_old.get(str));
                }
                parent.add(str);
                result.add(s);
            } else {
                new_old.put(str, s);
            }
        }

        return result;
    }
}
