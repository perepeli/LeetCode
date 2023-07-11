package problems.util;

public class UnionFind {
    private int size;
    private int sz[];
    private int[] id;
    private int numComponents;

    public UnionFind(int size) {
        if(size <= 0) throw new IllegalArgumentException("size <= 0 is not allowed");
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for(int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }

        while(p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int size() {
        return size;
    }

    public int components() {
        return numComponents;
    }

    public void unify(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) return;

        if(sz[rootP] < sz[rootQ]) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
        } else {
            sz[rootP] += sz[rootQ];
            id[rootQ] = rootP;
        }

        numComponents--;
    }
}
