package BinarySearch;

/**
 * 二分查找法 递归写法
 */
public class BinarySearch{
    private BinarySearch(){
    }

    public static <E extends Comparable<E>> int search(E[] data,E target){
        return search(data,0,data.length - 1,target);
    }

    private static <E extends Comparable<E>> int search(E[] data,int l,int r,E target){
        if(l > r) return -1;
        int mid = l + (r - l) / 2;
        if(data[mid].compareTo(target) == 0) return mid;
        if(data[mid].compareTo(target) < 0) return search(data,mid + 1,r,target);
        return search(data,l,mid - 1,target);
    }

    // > target 的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data,E target){
        int l = 0, r = data.length;

        // 在 data[l,r]求解
        while(l < r){
            int mid = l + (r - l) / 2;
            if(data[mid].compareTo(target) <= 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // > target，返回最小值索引
    // == target，返回最大索引
    public static <E extends Comparable<E>> int ceil(E[] data,E target){
        int u = upper(data,target);
        if(u - 1 >= 0 && data[u - 1].compareTo(target) == 0) return u - 1;
        return u;
    }
}