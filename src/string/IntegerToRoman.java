package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 7/19/14.
 * http://blog.csdn.net/havenoidea/article/details/11848921
 * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 * 右加左减：
 * 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
 * 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
 * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
 * 左减数字必须为一位，比如8写成VIII，而非IIX。
 * 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
 */

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1328));
        System.out.println(intToRoman(3999));
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(61));
        System.out.println(intToRoman(62));
        System.out.println(intToRoman(63));
        System.out.println(intToRoman(128));
    }

    private static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        String result = "";
        int multiplier = 1, modulor = 10;
        while (num > 0) {
            int tmp = num % modulor;

            if (tmp >= 5) {
                if (tmp < 9) {
                    String tmp_str = "";
                    for (int i = 0; i < tmp - 5; i++) {
                        tmp_str += map.get(multiplier);
                    }
                    result = map.get(5 * multiplier) + tmp_str + result;
                } else {
                    result = map.get(multiplier) + map.get(10 * multiplier) + result;
                }
            } else {
                if (tmp < 4) {
                    String tmp_str = "";
                    for (int i = 0; i < tmp; i++) {
                        tmp_str += map.get(multiplier);
                    }
                    result = tmp_str + result;
                } else {
                    result = map.get(multiplier) + map.get(5 * multiplier) + result;
                }
            }
            num = num / 10;
            multiplier *= 10;
        }

        return result;
    }
}
