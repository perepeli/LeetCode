package problems;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[n + m];

        int left = 0;
        int right = 0;

        int index = 0;

        while(left < m && right < n) {
            System.out.println(left + " " + right);

            if(nums1[left] < nums2[right]) {
                res[index] = nums1[left];
                left++;
            } else {
                res[index] = nums2[right];
                right++;
            }
            index++;
        }

        while(left < m) {
            res[index] = nums1[left];
            left++;
            index++;
        }

        while(right < n) {
            res[index] = nums2[right];
            right++;
            index++;
        }

        for(int i = 0; i < res.length; i++) nums1[i] = res[i];
    }
}
