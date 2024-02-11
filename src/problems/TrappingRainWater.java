package problems;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int left = 0;
        for(int i = 0; i < height.length; i++) {
            leftMax[i] = left;
            left = Math.max(left, height[i]);
        }
        int right = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = right;
            right = Math.max(right, height[i]);
        }

        int res = 0;
        for(int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(min > 0) res+= min;
        }
        return res;
    }
}
