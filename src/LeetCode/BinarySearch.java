package LeetCode;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearch{
    public int search(int[] nums,int target){
        return search(nums,0,nums.length - 1,target);
    }

    private int search(int[] data,int l,int r,int target){
        if(l > r) return -1;
        int mid = l + (r - l) / 2;
        if(data[mid] == (target)) return mid;
        if(data[mid] < (target)) return search(data,mid + 1,r,target);
        return search(data,l,mid - 1,target);
    }
}
