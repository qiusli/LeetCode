package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 6/21/14.
 */
public class ReverseString {
    public static void main(String[] args) {
//        String input = "the sky is blue";
        String input = "   ";
        System.out.print(reverseWords(input));
    }

    public static String reverseWords(String s) {
        if (s == null)
            return null;

        if (s.length() == 0 || s.length() == 1)
            return s.trim();

        List<String> list = new ArrayList<String>();
        String one_item = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                one_item += s.charAt(i);

                if (i == s.length() - 1 && !one_item.equals(""))
                    list.add(one_item);
            } else {
                list.add(one_item);
                one_item = "";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0) {
                result.append(list.get(i));
                break;
            }

            if (list.get(i).equals(""))
                result.append(list.get(i));
            else
                result.append(list.get(i)).append(" ");
        }

        return result.toString().trim();
    }
}
