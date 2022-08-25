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

        int i = l + 1, j = r;

        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0){
                i++;
            }
            while(j >= i && arr[j].compareTo(arr[l]) > 0){
                j--;
            }
            if(i >= j) break; // 所有元素遍历完，退出循环

            swap(arr,i,j);
            i++;
            j--;
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
