package problems;

public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int N) {
        String S = Integer.toString(N);
        int[] A = new int[S.length()];
        for (int i = 0; i < S.length(); ++i)
            A[i] = S.charAt(i) - '0';
        return permutations(A, 0);
    }

    public boolean isPowerOfTwo(int[] A) {
        if (A[0] == 0) return false;

        int N = 0;
        for (int x: A)
            N = 10 * N + x;

        while (N > 0 && ((N & 1) == 0))
            N >>= 1;

        return N == 1;
    }

    public boolean permutations(int[] A, int start) {
        if (start == A.length)
            return isPowerOfTwo(A);

        for (int i = start; i < A.length; ++i) {
            swap(A, start, i);


            if (permutations(A, start + 1))
                return true;

            swap(A, start, i);
        }

        return false;
    }

    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
