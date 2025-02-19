package problems;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int[] freqS = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
        }
        int[] freqT = new int[26];
        for(int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - 'a']++;
        }

        int res = 0;

        for(int i = 0; i < freqS.length; i++) {
            int min = Math.min(freqS[i], freqT[i]);
            freqT[i] -= min;
            res += freqT[i];
        }

        return res;
    }
}
