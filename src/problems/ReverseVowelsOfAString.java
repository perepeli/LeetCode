package problems;

import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            char leftChar = arr[left];
            char rightChar = arr[right];

            if(vowels.contains(leftChar) && vowels.contains(rightChar)) {
                arr[left] = rightChar;
                arr[right] = leftChar;
                left++;
                right--;
            } else if(vowels.contains(leftChar)) {
                right--;
            } else if(vowels.contains(rightChar)) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return String.valueOf(arr);
    }
}
