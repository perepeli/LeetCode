package problems;

public class LexicographicallySmallestStringAfterSubstringOperation {
    public String smallestString(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = 0;

        while(right < arr.length) {
            if(arr[left] == 'a') {
                left++;
                right++;
            } else if(right + 1 < arr.length && arr[right + 1] != 'a') {
                right++;
            } else {
                break;
            }
        }

        if(left == right && right == s.length()) {
            arr[arr.length - 1] = 'z';
            return String.valueOf(arr);
        }

        for(int i = left; i <= right && i < arr.length; i++) {
            arr[i] = (char)(arr[i] - 1);
        }

        return String.valueOf(arr);
    }
}
