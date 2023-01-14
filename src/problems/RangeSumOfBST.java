package problems;

import problems.listnode.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Placeholder placeholder = new Placeholder(low, high, 0);

        depthFirstSearch(root, placeholder);

        return placeholder.get();
    }

    public void depthFirstSearch(TreeNode root, Placeholder placeholder) {
        if(root == null) return;
        placeholder.add(root.val);
        depthFirstSearch(root.left, placeholder);
        depthFirstSearch(root.right, placeholder);
    }


}
class Placeholder {
    private int num;
    private final int low;
    private final int high;
    public Placeholder(int low, int high, int num) {
        this.low = low;
        this.high = high;
        this.num = num;
    }
    public void add(int num) {
        if(withinRange(num)) {
            this.num += num;
        }
    }
    public int get() {
        return this.num;
    }
    public boolean withinRange(int value) {
        return (value >= this.low && value <= this.high) ? true : false;
    }
}
