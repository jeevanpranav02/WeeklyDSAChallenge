public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(nums));
    }

    static int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < height.length - 2 && j >= 0)
        {
            area = Math.max(area, Math.min(height[i], height[j]) * Math.abs((int)i - j));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return area;
    }
}