package problems;

public class NumberOfDivisibleSubstrings {
    public int countDivisibleSubstrings(String word) {
        int[] values = new int[]{1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};

        int n = word.length();
        int count = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = values[word.charAt(0) - 'a'];

        for (int i = 1; i < n; i ++) {
            int index = word.charAt(i) - 'a';
            prefixSum[i] = prefixSum[i - 1] + values[index];
        }

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int substringSum;

                if(i == 0) substringSum = prefixSum[j];
                else substringSum = prefixSum[j] - prefixSum[i - 1];

                int length = j - i + 1;

                if(substringSum % length == 0) {
                    count++;
                }

            }
        }



        return count;
    }
}
