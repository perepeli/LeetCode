package problems;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;

        int lastWord1 = -1;
        int lastWord2 = -1;

        for(int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];

            if(word1.equals(word)) {
                if(lastWord2 >= 0) {
                    res = Math.min(res, i - lastWord2);
                }

                lastWord1 = i;
            } else if(word2.equals(word)) {
                if(lastWord1 >= 0) {
                    res = Math.min(res, i - lastWord1);
                }

                lastWord2  = i;
            }
        }


        return res;
    }
}
