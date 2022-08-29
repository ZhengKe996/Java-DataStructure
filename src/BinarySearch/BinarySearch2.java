package BinarySearch;

/**
 * 二分查找法 非递归写法
 */
public class BinarySearch2{
    private BinarySearch2(){
    }

    public static <E extends Comparable<E>> int search(E[] data,E target){
        int l = 0, r = data.length - 1;
        // 在 data[l,r]的范围查找target
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(data[mid].compareTo(target) == 0) return mid;
            if(data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

}
