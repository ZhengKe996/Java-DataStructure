package LeetCode;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组 nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2{
    public void sortColors(int[] nums){
        int zero = -1, i = 0, two = nums.length;
        while(i < two){
            if(nums[i] == 0){
                zero++;
                swap(nums,zero,i);
                i++;
            }else if(nums[i] == 2){
                two--;
                swap(nums,i,two);
            }else{
                i++;
            }

        }
    }

    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
