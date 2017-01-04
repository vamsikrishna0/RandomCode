package leetcode;

/**
 * Created by Vamsi on 12/31/2016.
 */
public class ContainerWithMaxWater {
    //Given set of bars of some height(heights array), find a pair with max area
    public static void main(String[] args) {
        ContainerWithMaxWater x = new ContainerWithMaxWater();
    }

    public int maxArea(int[] height) {
        int len = height.length, left = 0, right = len - 1;
        int max = 0;
        if (len <= 1)
            return 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
