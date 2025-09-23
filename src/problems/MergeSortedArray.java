package problems;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastM = m - 1;
        int lastN = n - 1;
        int lastIndex = nums1.length - 1;

        while(lastM >= 0 && lastN >= 0) {
            if(nums1[lastM] > nums2[lastN]) {
                nums1[lastIndex--] = nums1[lastM--];
            } else {
                nums1[lastIndex--] = nums2[lastN--];
            }
        }

        while(lastN >= 0) {
            nums1[lastIndex--] = nums2[lastN--];
        }
    }
}
