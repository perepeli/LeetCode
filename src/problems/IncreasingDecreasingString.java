package problems;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        boolean isStartLeft = true;
        while(true) {
            int numberOfZeroes = 0;
            if(isStartLeft) {
                for(int i = 0; i < arr.length; i++) {
                    if(arr[i] != 0) {
                        sb.append((char)(i + 'a'));
                        arr[i]--;
                    }
                    if(arr[i] == 0) numberOfZeroes++;
                }
            } else {
                for(int i = arr.length - 1; i >= 0; i--) {
                    if(arr[i] != 0) {
                        sb.append((char)(i + 'a'));
                        arr[i]--;
                    }
                    if(arr[i] == 0) numberOfZeroes++;
                }

            }
            if(numberOfZeroes == 26) break;
            isStartLeft = !isStartLeft;
        }

        return sb.toString();
    }
}
