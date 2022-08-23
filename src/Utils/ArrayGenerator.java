package Utils;

import java.util.Random;

/*
 * TODO:数组生成器
 * */
public class ArrayGenerator{
    private ArrayGenerator(){
    }

    /**
     * 生成n长的有序数组
     * @param n 长度
     * @return
     */
    public static Integer[] generateOrderArray(int n){
        Integer[] arr = new Integer[n];
        for(int i = 0;i < n;i++){
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成n长度的随机数组
     * @param n 长度
     * @param bound 最大值
     * @return
     */
    public static Integer[] generateRandomArray(int n,int bound){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for(int i = 0;i < n;i++){
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
