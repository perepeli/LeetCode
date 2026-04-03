package problems;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        int i;

        for(i=0;i<(1<<n);i++) list.add(start^i^(i>>1));

        return list;
    }
}
