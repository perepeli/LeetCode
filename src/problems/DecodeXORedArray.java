package problems;

public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length, res[] = new int[n + 1];
        res[0] = first;
        for (int i = 0; i < n; ++i)
            res[i + 1] = res[i] ^ encoded[i];
        return res;
    }
}
