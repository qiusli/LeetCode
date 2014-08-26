package greedy;

/**
 * Created by liqiushi on 8/21/14.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {3, 1, 2, 1, 5, 2, 3};
        System.out.println(maxArea(height));

        int[] height1 = {1, 1};
        System.out.println(maxArea(height1));

        int[] height2 = {5, 4, 3, 2, 1};
        System.out.println(maxArea(height2));

        int[] height3 = {1, 2, 1};
        System.out.println(maxArea(height3));
    }

    private static int maxArea(int[] height) {
        if (height == null)
            return 0;

        int rear = 0, front = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (rear < front) {
            int area = Math.min(height[rear], height[front]) * (front - rear);
            maxArea = Math.max(area, maxArea);

            if (height[rear] < height[front])
                rear++;
            else
                front--;
        }

        return maxArea;
    }
}
