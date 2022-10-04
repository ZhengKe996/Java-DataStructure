package ShellSort;

/**
 * 实现希尔排序
 */
public class ShellSort {
    private ShellSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        int h = data.length / 2;
        while (h >= 1) {
            for (int i = h; i < data.length; i++) {
                E e = data[i];
                int j;
                for (j = i; j - h >= 0 && e.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = e;
            }
            h /= 2;
        }
    }
}
