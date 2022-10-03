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
}
