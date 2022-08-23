package MergeSort;

import Utils.ArrayGenerator;
import Utils.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort<T>{
    private MergeSort(){
    }

    public static <T extends Comparable<T>> void sort(T[] arr){
        sort(arr,0,arr.length - 1);
    }

    /**
     * 递归的sort函数
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sort(T[] arr,int l,int r){
        if(l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr,l,mid);
        sort(arr,mid + 1,r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0) merge(arr,l,mid,r);
    }

    /**
     * 合并两个有序的区间 arr[l,mid]和arr[mid+1,r]
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void merge(T[] arr,int l,int mid,int r){
        T[] temp = Arrays.copyOfRange(arr,l,r + 1);

        int i = l, j = mid + 1;

        // 每轮循环为arr[k]赋值;
        for(int k = l;k <= r;k++){
            if(i > mid){
                arr[k] = temp[j - l];
                j++;
            }else if(j > r){
                arr[k] = temp[i - l];
                i++;
            }else if(temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l];
                i++;
            }else{
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args){
        int n = 100000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("MergeSort",array);
    }
}
