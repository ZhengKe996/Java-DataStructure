package MergeSort;

/*
 * 插入排序
 * */
public class InsertionSort{
    private InsertionSort(){
    }

    /**
     * 为归并排序优化的插入排序
     * @param arr
     * @param l
     * @param r
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        for(int i = l;i <= r;i++){
            E t = arr[i];
            int j;
            for(j = i;j - 1 >= l && t.compareTo(arr[j - 1]) < 0;j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }


}
