public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(nums));
    }

    static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int maxHeight,temp;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            temp = r - l;
            if (height[l] < height[r]) {
                maxHeight = height[l++];
            } else {
                maxHeight = height[r--];
            }
            temp = maxHeight * temp;
            if (temp > maxArea) {
                maxArea = temp;
            }
        }
        return maxArea;
    }
}