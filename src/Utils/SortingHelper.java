package Utils;

public class SortingHelper{
    private SortingHelper(){
    }

    /**
     * 判断数组前一项与后一项是否有序
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr){
        for(int i = 1;i < arr.length;i++)
            if(arr[i - 1].compareTo(arr[i]) > 0) return false;
        return true;
    }

    /**
     * 排序算法测试
     *
     * @param sortname 排序算法名
     * @param arr      数组
     * @param <T>
     */
    public static <T extends Comparable<T>> void sortTest(String sortname,T[] arr){
        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort")) Sort.SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort")) Sort.InsertionSort.sort(arr);
        else if(sortname.equals("MergeSort")) MergeSort.MergeSort.sort(arr);
        else if(sortname.equals("MergeSortBU")) MergeSort.MergeSort.sortBU(arr);

        long endTime = System.nanoTime();
//        for(T value: arr){
//            System.out.print(value + " ");
//        }
        System.out.println();
        if(!isSorted(arr)) throw new RuntimeException(String.format("%s failed",sortname));
        System.out.printf("%s 排序，所用时间: %s 秒",sortname,(endTime - startTime) / 1000000000.0);
    }
}
