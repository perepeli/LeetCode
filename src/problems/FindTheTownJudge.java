package problems;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] votes = new int[n];

        for(int[] i : trust) {
            votes[i[0]-1]--;
            votes[i[1]-1]++;
        }

        for(int i = 0; i < votes.length; i++) {
            if(votes[i] == n-1) return i+1;
        }

        return -1;
    }
}
