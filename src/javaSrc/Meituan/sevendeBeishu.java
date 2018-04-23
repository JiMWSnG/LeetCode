/*
package javaSrc.Meituan;

import java.util.Scanner;

*/
/**
 * @author Jim Wang
 * @create 2017-09-14 20:58
 **//*

public class sevendeBeishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        System.out.println(getCount(nums));
    }

    public static int getCount(long[] nums,int s, int e) {
        int res = 0;
        if (nums == null || e-s<2){
            return 0;
        }
        if (e-s ==2 ){
            return getLegal(nums[s], nums[e]);
        }else{

        }
        return res;

    }
    public static int getLegal(long a, long b){
        int res =0;
        if (merge(a, b)%7 == 0)
            res++;
        if (merge(b, a)%7 == 0)
            res++;
        return res;
    }


    public static long merge(long a, long b) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf(a)).append(String.valueOf(b));
        return Long.valueOf(sb.toString());
    }

}
*/
