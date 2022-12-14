package LeetCode;

import java.util.Arrays;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4{
    public int shipWithinDays(int[] weights,int days){
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while(l < r){
            int mid = l + (r - l) / 2;
            if(days(weights,mid) <= days)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int days(int[] weights,int k){
        int cur = 0, res = 0;
        for(int weight: weights)
            if(cur + weight <= k) cur += weight;
            else{
                res++;
                cur = weight;
            }
        res++;
        return res;
    }
}
