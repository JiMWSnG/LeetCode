package javaSrc.Didi;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-09-10 16:05
 **/
public class Xor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i =0; i< n; i++){
            a[i] = sc.nextInt();
        }
        int result = getXorNum(a);
        System.out.println(result);

    }

    public static int getXorNum(int[] a){
        if (a == null || a.length== 0){
            return 0;
        }
        int n = a.length;
        Arrays.sort(a);
        int[] dp = new int[n+1];
        dp[0] = 0;
        if (a[0] == 0){
            dp[1] =1;
        }else{
            dp[1]=0;
        }
        int last = 0;
        for (int i =1; i<n; i++){
            if (isLegal(a[i-1], a[i])){
                dp[i+1] = dp[i]+1;
                last = i;
            }else{
                dp[i+1] =dp[i];
                for (int j = last; j<i;j++){
                    if (isLegal(a[j],a[i])){
                        dp[i+1] = dp[i]+1;
                        last = i;
                    }
                }

            }
        }
        return dp[n];

    }
    public static boolean isLegal(int left, int right){
        if (left > right){
            return false;
        }
        int result = 0;
        for (int i = left; i<= right; i++){
            result ^= i;
        }
        return result == 0;
    }
}
