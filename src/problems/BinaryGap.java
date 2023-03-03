package problems;

import java.util.Arrays;

public class BinaryGap {
    public int binaryGap(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();

        System.out.println(Arrays.toString(arr));

        int longestDistance = 0;

        int firstIndex = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                firstIndex = i;
                break;
            }
        }

        if(firstIndex == -1) return 0;

        for(int i = firstIndex + 1; i < arr.length; i++) {
            if(arr[i] == '1') {
                longestDistance = Math.max(longestDistance, i - firstIndex);
                //System.out.println(firstIndex + " - " + i);
                firstIndex = i;
            }
        }
        return longestDistance;
    }
}
