package BubbleSort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i + 1 < data.length; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = data.length - lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }
}
