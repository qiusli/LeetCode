package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liqiushi on 6/21/14.
 */
public class EvalRPN {
    public static void main(String[] args) {
        List<String> chars = new ArrayList<String>();
//        chars.addAll(Arrays.asList("2", "1", "+", "3", "*"));
//        chars.addAll(Arrays.asList("4", "13", "5", "/", "+"));

        String[] input = {"4", "13", "5", "/", "+"};

        System.out.println(eval(input));
    }

    private static int eval(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return -1;

        if (tokens.length == 1)
            return (int) Double.parseDouble(tokens[0]);

        double result = 0.0;
        Stack<Double> nums = new Stack<Double>();
        for (String a : tokens) {
            if (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {
                if (a.equals("+")) {
                    double rightNum = nums.pop();
                    double leftNum = nums.pop();
                    result = leftNum + rightNum;

                    nums.push(result);
                } else if (a.equals("-")) {
                    double rightNum = nums.pop();
                    double leftNum = nums.pop();
                    result = leftNum - rightNum;

                    nums.push(result);
                } else if (a.equals("*")) {
                    double rightNum = nums.pop();
                    double leftNum = nums.pop();
                    result = leftNum * rightNum;

                    nums.push(result);
                } else if (a.equals("/")) {
                    int rightNum = (int) nums.pop().doubleValue();
                    int leftNum = (int) nums.pop().doubleValue();
                    result = leftNum / rightNum;

                    nums.push(result);
                }
            } else {
                double d = Double.parseDouble(a);
                nums.push(d);
            }
        }

        return (int) result;
    }
}
