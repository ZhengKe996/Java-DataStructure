package UnionFind;

public class QuickUnion3 implements UF {
    private int[] parent;
    private int[] rank;

    public QuickUnion3(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
