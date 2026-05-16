package problems;

public class NumberOfSubarraysWithGCDEqualToK {
    public static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }

    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int g = nums[i];
            for(int j=i; j<nums.length; j++){
                g = gcd(g, nums[j]);
                if(g == k) count++;
            }
        }
        return count;
    }
}
