package problems;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        int sum = 0;
        for(int e : nums) {
            if(arr[e] == 0) {
                sum+=e;
            } else if(arr[e] == 1) {
                sum-=e;
            }
            arr[e]++;
        }
        return sum;


    }
}
