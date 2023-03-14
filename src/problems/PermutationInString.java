package problems;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            map[currentChar - 'a']++;
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] tempMap = new int[26];
            for(int j = i; j < i + s1.length(); j++) {
                tempMap[s2.charAt(j) - 'a']++;
            }
            if(arrayEquals(map, tempMap)) return true;
        }

        return false;
    }


    private boolean arrayEquals(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return false;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
