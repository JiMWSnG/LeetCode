package javaSrc.Didi;


import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-08-26 16:17
 **/

public class lianxuZuidaSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            list.add(a);
        }
        int[] nums = new int[list.size()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        System.out.println(FindGreatestSumOfSubArray(nums));
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array ==null||array.length==0)
            return 0;
        int result = Integer.MIN_VALUE;
        int max=0;
        for(int i=0;i<array.length;i++){
            max+=array[i];
            result = result>max?result:max;
            if(max<0)
                max=0;
        }
        return result;
    }
}


