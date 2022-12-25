package problems;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int distance = right - left;
        int leftHeight = height[left];
        int rightheight = height[right];

        int maxArea = 0;


        while(left != right) {
            int area;
            if(leftHeight > rightheight) {
                area = rightheight * distance;

                right--;
            } else {
                area = leftHeight * distance;

                left++;
            }
            distance = right - left;
            leftHeight = height[left];
            rightheight = height[right];

            if(area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
