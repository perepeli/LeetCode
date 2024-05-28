package problems;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int res = 0;

        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                char prev = strs[j - 1].charAt(i);
                char curr = strs[j].charAt(i);

                if(prev > curr) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
