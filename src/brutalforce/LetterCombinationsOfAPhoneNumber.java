package brutalforce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/8/14.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        List<String> result = letterCombinations("2");

        for (String s : result)
            System.out.print(s + " ");
    }

    //    Input:Digit string "23"
    //    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    private static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.trim().length() == 0) {
            list.add("");
            return list;
        }

        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int curDepth = 0;
        List<String> result = new ArrayList<String>();
        StringBuffer subset = new StringBuffer();
        dfs(digits, str, curDepth, subset, result);

        return result;
    }

    private static void dfs(String digits, String[] strs, int curDepth, StringBuffer subset, List<String> result) {
        if (curDepth == digits.length()) {
            StringBuffer sb = new StringBuffer(subset);
            result.add(sb.toString());
            return;
        }

        String curStr = strs[Integer.valueOf(String.valueOf(digits.charAt(curDepth)))];
        for (int i = 0; i < curStr.length(); i++) {
            subset.append(String.valueOf(curStr.charAt(i)));
            dfs(digits, strs, curDepth + 1, subset, result);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
