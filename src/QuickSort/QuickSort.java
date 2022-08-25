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

        // 生成 [l,r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr,l,p);

        // arr[l+1,lt]<v, arr[lt+1,i-1] == v,arr[gt,r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt){
            if(arr[i].compareTo(arr[l]) < 0){
                lt++;
                swap(arr,i,lt);
                i++;
            }else if(arr[i].compareTo(arr[l]) > 0){
                gt--;
                swap(arr,i,gt);
            }else{
                i++;
            }
        }
        // arr[l,lt-1]<v, arr[lt,gt-1] == v,arr[gt,r] > v
        swap(arr,l,lt);
        sort(arr,l,lt - 1,rnd);
        sort(arr,gt,r,rnd);
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
