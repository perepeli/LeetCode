package problems;

import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        int[] res = new int[]{0};
        backtrack(arr, 0, new int[26], res);
        return res[0];
    }

    private void backtrack(List<String> arr, int index, int[] mask, int[] res) {
        if(index == arr.size()) {
            return;
        } else {
            for(int i = index; i < arr.size(); i++) {
                String curr = arr.get(i);
                boolean isValid = true;

                for(int j = 0; j < curr.length(); j++) {
                    int pos = curr.charAt(j) - 'a';
                    mask[pos]++;
                    if(mask[pos] > 1) isValid = false;
                }

                if(isValid) {
                    int count = 0;
                    for(int k : mask) if(k == 1) count++;
                    res[0] = Math.max(res[0], count);

                    backtrack(arr, i + 1, mask, res);
                }

                for(int j = 0; j < curr.length(); j++) {
                    int pos = curr.charAt(j) - 'a';
                    mask[pos]--;
                }
            }
        }
    }
}
