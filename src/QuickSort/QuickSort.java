package QuickSort;



/**
 * 快速排序
 */
public class QuickSort{
    private QuickSort(){
    }

    public static <T extends Comparable<T>> void sort(T[] arr){
        sort(arr,0,arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr,int l,int r){
        if(l >= r) return;
        // 标定点索引
        int p = partition(arr,l,r);
        sort(arr,l,p - 1);
        sort(arr,p + 1,r);
    }

    private static <T extends Comparable<T>> int partition(T[] arr,int l,int r){
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
