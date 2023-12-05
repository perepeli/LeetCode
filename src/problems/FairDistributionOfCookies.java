package problems;

public class FairDistributionOfCookies {
    public int distributeCookies(int[] cookies, int k) {
        int[] res = new int[]{Integer.MAX_VALUE};
        int[] children = new int[k];
        backtrack(cookies, 0, children, k, res);
        return res[0] == Integer.MAX_VALUE ? 0 : res[0];
    }

    private void backtrack(int[] cookies, int cookieIndex, int[] children, int k, int[] res) {
        if(cookieIndex == cookies.length) {
            int max = 0;
            for(int i : children) {
                if(i == 0) return;
                max = Math.max(max, i);
            }
            res[0] = Math.min(res[0], max);
        } else {
            for(int i = 0; i < children.length; i++) {
                children[i] += cookies[cookieIndex];
                backtrack(cookies, cookieIndex + 1, children, k, res);
                children[i] -= cookies[cookieIndex];
            }
        }
    }
}
