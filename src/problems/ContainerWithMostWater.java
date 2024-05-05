package problems;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            max = Math.max(max, Math.min(leftHeight, rightHeight) * (right - left));

            if(leftHeight < rightHeight) left++;
            else right--;
        }

        return max;
    }
}
