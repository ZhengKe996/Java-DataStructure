package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素节点的左 孩子节点索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素节点的右孩子节点索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return (index + 1) * 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * siftUp：
     * 堆中某个节点的值总是不大于其父节点的值, 超过即需要交换位置
     *
     * @param k
     */
    private void siftUp(int k) {
        /**
         * 交换条件：
         * 1. 下标大于0
         * 2. 自身值大于父节点的值
         */
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E max = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    /**
     * siftDown 下沉操作
     *
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 找到k的左右子节点中较大的一个
            int childIndex = leftChild(k);
            if (childIndex + 1 < data.getSize() && data.get(childIndex + 1).compareTo(data.get(childIndex)) > 0) {
                childIndex = rightChild(k); // data[j]是 leftChild 和 rightChild 中的最大值
            }

            // 如果 k 的左右节点较大的一个小于k的值，跳出循环，否则交换位置
            if (data.get(k).compareTo(data.get(childIndex)) >= 0) {
                break;
            }

            data.swap(k, childIndex); // 交换完成后，将 j 赋值给k
            k = childIndex;
        }
    }
}
