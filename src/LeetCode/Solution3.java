package LeetCode;

import java.util.Arrays;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3{
    public int minEatingSpeed(int[] piles,int h){
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while(l < r){
            int mid = l + (r - l) / 2;
            if(eatingTime(piles,mid) <= h)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int eatingTime(int[] piles,int k){
        int res = 0;
        for(int pile: piles){
            res += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return res;
    }
}
