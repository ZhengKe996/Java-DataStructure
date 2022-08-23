package QuickSort;

import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort{
    private QuickSort(){
    }

    public static <T extends Comparable<T>> void sort(T[] arr){
        Random rnd = new Random();
        sort(arr,0,arr.length - 1,rnd);
    }

    private static <T extends Comparable<T>> void sort(T[] arr,int l,int r,Random rnd){
        if(l >= r) return;
        // 标定点索引
        int p = partition(arr,l,r,rnd);
        sort(arr,l,p - 1,rnd);
        sort(arr,p + 1,r,rnd);
    }

    private static <T extends Comparable<T>> int partition(T[] arr,int l,int r,Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr,l,p);
        int j = l;
        for(int i = l + 1;i <= r;i++){
            if(arr[i].compareTo(arr[l]) < 0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    private static <T> void swap(T[] arr,int i,int j){
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
