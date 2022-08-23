package Sort;

import Utils.ArrayGenerator;
import Utils.SortingHelper;

/*
 * 插入排序
 * */
public class InsertionSort{
    private InsertionSort(){
    }

    /**
     * 插入排序
     *
     * @param arr 乱序数组
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i = 0;i < arr.length;i++){
            E t = arr[i];
            int j;
            for(j = i;j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0;j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <T> void swap(T[] arr,int i,int j){
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        int n = 100000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("InsertionSort",array);
    }
}
