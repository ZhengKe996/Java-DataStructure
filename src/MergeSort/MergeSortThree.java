package MergeSort;

import Utils.ArrayGenerator;
import Utils.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSortThree<T>{
    private MergeSortThree(){
    }

    public static <T extends Comparable<T>> void sort(T[] arr){
        T[] temp = Arrays.copyOf(arr,arr.length);
        sort(arr,0,arr.length - 1,temp);
    }

    /**
     * 递归的sort函数
     *
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sort(T[] arr,int l,int r,T[] temp){
        if(l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr,l,mid,temp);
        sort(arr,mid + 1,r,temp);
        if(arr[mid].compareTo(arr[mid + 1]) > 0) merge(arr,l,mid,r,temp);
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
    private static <T extends Comparable<T>> void merge(T[] arr,int l,int mid,int r,T[] temp){
        System.arraycopy(arr,l,temp,l,r - l + 1);
        int i = l, j = mid + 1;

        // 每轮循环为arr[k]赋值;
        for(int k = l;k <= r;k++){
            if(i > mid){
                arr[k] = temp[j];
                j++;
            }else if(j > r){
                arr[k] = temp[i];
                i++;
            }else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args){
        int n = 100000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("MergeSortThree",array);
    }
}
