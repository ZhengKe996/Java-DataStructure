package Sort;

import Utils.ArrayGenerator;
import Utils.SortingHelper;

/*
 * 选择排序
 * */
public class SelectionSort{
    private SelectionSort(){
    }

    /**
     * 选择排序
     * @param arr 未排序数组
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] arr){
        for(int i = 0;i < arr.length;i++){
            int minIndex = i;
            for(int j = i;j < arr.length;j++){
                if(arr[j].compareTo(arr[minIndex]) < 0) minIndex = j;
            }
            swap(arr,i,minIndex);
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
        SortingHelper.sortTest("SelectionSort",array);
    }
}
