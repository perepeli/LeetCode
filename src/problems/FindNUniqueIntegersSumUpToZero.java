package problems;

public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int num = 1;
        int index = 0;

        if(n % 2 != 0) res[index++] = 0;

        while(index < n) {
            res[index++] = num;
            res[index++] = -num;
            num++;
        }

        return res;
    }
}
