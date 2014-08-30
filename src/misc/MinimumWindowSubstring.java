package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/29/14.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private static String minWindow(String S, String T) {
        if (S == null || S.length() == 0)
            return "";

        if (T == null || T.length() == 0)
            return "";

        int[] t = new int[128];
        for (int i = 0; i < T.length(); i++) {
            t[T.charAt(i)]++;
        }

        int[] s = new int[128];
        int start = 0;
        int found = 0;
        int len = Integer.MAX_VALUE, shortest_start = -1;
        for (int i = 0; i < S.length(); i++) {
            if (t[S.charAt(i)] != 0) {
                s[S.charAt(i)]++;

                if (s[S.charAt(i)] <= t[S.charAt(i)])
                    found++;

                if (found == T.length()) {
                    while (start < i) {
                        if (s[S.charAt(start)] == 0 ||
                                (s[S.charAt(start)] != 0 && --s[S.charAt(start)] >= t[S.charAt(start)])) {
                            //上面的--s[S.charAt(start)]非常重要,它表示无论如何都要减一
                            start++;
                        } else {
                            break;
                        }
                    }

                    if (i - start + 1 < len) {
                        len = i - start + 1;
                        shortest_start = start;
                    }

                    found--;
                    start++;
                }
            }
        }

        return shortest_start == -1 ? "" : S.substring(shortest_start, shortest_start + len);
    }

    // exceeds time limit
    private static String minWindow1(String S, String T) {
        if (S == null || S.length() == 0)
            return "";

        if (T == null || T.length() == 0)
            return "";

        int shortest = Integer.MAX_VALUE;
        int start = -1, end = -1;
        int t_start = -1, t_end = -1;
        List<String> list_t = getCharacters(T);
        boolean found = false;
        for (int i = 0; i < S.length(); i++) {
            if (list_t.contains(String.valueOf(S.charAt(i)))) {
                if (start == -1) {
                    start = i;
                }
                list_t.remove(String.valueOf(S.charAt(i)));
                if (list_t.size() == 0) {
                    end = i;
                    if (end - start + 1 < shortest) {
                        shortest = end - start + 1;
                        t_start = start;
                        t_end = end;
                        found = true;
                    }

                    list_t = getCharacters(T);
                    start = -1;
                }
            }
        }

        return found ? S.substring(t_start, t_end + 1) : "";
    }

    // exceeds time limit
    private static List<String> getCharacters(String T) {
        List<String> list_t = new ArrayList<String>();
        for (int i = 0; i < T.length(); i++)
            list_t.add(String.valueOf(T.charAt(i)));
        return list_t;
    }
}
