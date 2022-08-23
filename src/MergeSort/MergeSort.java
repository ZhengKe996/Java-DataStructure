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

    /**
     * 自顶向下的归并排序
     *
     * @param arr
     * @param <T>
     */
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
     * 自底向上的归并排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void sortBU(T[] arr){
        T[] temp = Arrays.copyOf(arr,arr.length);
        int n = arr.length;

        // 遍历合并的区间长度
        for(int sz = 1;sz < n;sz += sz){
            // 遍历合并的两个区间的起始位置 i  合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for(int i = 0;i + sz < n;i += sz + sz){
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr,i,i + sz - 1,Math.min(i + sz + sz - 1,n - 1),temp);
            }
        }
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
        int n = 5000000;
        Integer[] array = ArrayGenerator.generateRandomArray(n,n);
        Integer[] array2 = Arrays.copyOf(array,array.length);
        SortingHelper.sortTest("MergeSort",array);
        SortingHelper.sortTest("MergeSortBU",array2);
    }
}
