package LeetCode.NumArray;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * <p>
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    private interface Merger<E> {
        E merge(E a, E b);
    }

    public class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];

            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];

            buildSegmentTree(0, 0, data.length - 1);
        }

        /**
         * 在treeIndex 的位置创建表示区间[l...r]的线段树
         *
         * @param treeIndex
         * @param l
         * @param r
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {

            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        /**
         * 返回区间[queryL,queryR]的值
         *
         * @param queryL
         * @param queryR
         * @return
         */
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
                throw new IllegalArgumentException("Index is illegal.");
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在以treeID为根的线段树中[l...r]的范围里，搜索区间[queryL,queryR]的值
         *
         * @param treeIndex
         * @param l
         * @param r
         * @param queryL
         * @param queryR
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        public E get(int index) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal.");
            return data[index];
        }

        public int getSize() {
            return data.length;
        }

        /**
         * 返回完全二叉树的数组中表示一个索引所表示的元素的左子节点索引
         *
         * @param index
         * @return
         */
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) builder.append(tree[i]);
                else builder.append("null");
                if (i != tree.length - 1) builder.append(", ");
            }
            builder.append(']');
            return builder.toString();
        }

        /**
         * 返回完全二叉树的数组中表示一个索引所表示的元素的右子节点索引
         *
         * @param index
         * @return
         */
        private int rightChild(int index) {
            return 2 * index + 2;
        }
    }


    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }

            segmentTree = new SegmentTree<>(data, ((a, b) -> a + b));
        }
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null)
            throw new IllegalArgumentException("Segment Tree is NULL");
        return segmentTree.query(left, right);
    }
}
