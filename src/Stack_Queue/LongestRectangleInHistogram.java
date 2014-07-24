package Stack_Queue;

import java.util.Stack;

/**
 * Created by liqiushi on 7/21/14.
 * http://blog.csdn.net/doc_sgl/article/details/11805519
 */
public class LongestRectangleInHistogram {
    public static void main(String[] args) {
        int[] height1 = {2, 1, 5, 6, 2, 3};
        int[] height2 = {1, 2, 3, 4, 5, 6};
        int[] height3 = {4, 2};
        int[] height4 = {2, 1, 2};
        int[] height5 = {4, 2, 0, 3, 2, 5};
        int[] height6 = {3, 6, 5, 7, 4, 8, 1, 0};
        System.out.println(largestRectangleArea(height1));
        System.out.println(largestRectangleArea(height2));
        System.out.println(largestRectangleArea(height3));
        System.out.println(largestRectangleArea(height4));
        System.out.println(largestRectangleArea(height5));
        System.out.println(largestRectangleArea(height6));
    }

    private static int largestRectangleArea(int[] height) {
        if (height == null)
            return 0;

        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; ) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int t = stack.pop();
                area = Math.max(area, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ?
                    height.length :
                    height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }

        return area;
    }
}
