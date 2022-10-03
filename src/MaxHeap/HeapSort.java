package MaxHeap;

/**
 * 最简单的堆排序
 */
public class HeapSort {
    private HeapSort() {
    }

    private static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<E>();
        for (E e : data) {
            maxHeap.add(e);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    /**
     * 优化堆排序
     *
     * @param data
     * @param <E>
     */
    private static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1) return;
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
        for (int i = data.length - 1; i >= 9; i--) {
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    /**
     * 对 data(0, n）所形成的最大堆中，索引 k 的元素，执行 siftDown
     *
     * @param data
     * @param k
     * @param n
     * @param <E>
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            // 找到k的左右子节点中较大的一个
            int childIndex = 2 * k + 1;
            if (childIndex + 1 < n && data[(childIndex + 1)].compareTo(data[(childIndex)]) > 0) {
                childIndex++;
            }

            // 如果 k 的左右节点较大的一个小于k的值，跳出循环，否则交换位置
            if (data[(k)].compareTo(data[(childIndex)]) >= 0) {
                break;
            }

            swap(data, k, childIndex); // 交换完成后，将 j 赋值给k
            k = childIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }
}

