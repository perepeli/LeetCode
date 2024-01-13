package problems;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for(NestedInteger node : nestedList) {
            sum += recursive(node, 1);
        }
        return sum;
    }

    private int recursive(NestedInteger nestedList, int depth) {
        if(nestedList.isInteger()) return depth * nestedList.getInteger();

        int sum = 0;

        for(NestedInteger node : nestedList.getList()) {
            sum += recursive(node, depth + 1);
        }

        return sum;
    }
}

interface NestedInteger {
//    NestedInteger();
//    NestedInteger(int value);
    boolean isInteger();
    Integer getInteger();
    void setInteger(int value);
    void add(NestedInteger ni);
    List<NestedInteger> getList();
}
