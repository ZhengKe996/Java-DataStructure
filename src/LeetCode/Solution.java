package LeetCode;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution{
    public int reversePairs(int[] nums){
        int[] temp = new int[nums.length];
        return sort(nums,0,nums.length - 1,temp);
    }

    private int sort(int[] arr,int l,int r,int[] temp){
        if(l >= r) return 0;
        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(arr,l,mid,temp);
        res += sort(arr,mid + 1,r,temp);
        if(arr[mid] > (arr[mid + 1])) res += merge(arr,l,mid,r,temp);
        return res;
    }

    private int merge(int[] arr,int l,int mid,int r,int[] temp){
        System.arraycopy(arr,l,temp,l,r - l + 1);
        int i = l, j = mid + 1, res = 0;

        for(int k = l;k <= r;k++){
            if(i > mid){
                arr[k] = temp[j];
                j++;
            }else if(j > r){
                arr[k] = temp[i];
                i++;
            }else if(temp[i] <= (temp[j])){
                arr[k] = temp[i];
                i++;
            }else{
                res += mid - i + 1;
                arr[k] = temp[j];
                j++;
            }
        }
        return res;
    }
}
