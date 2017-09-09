package javaSrc.Toutiao;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-08-22 19:58
 **/
public class getMinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int[] dpMax = new int[N];
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (min  == 0){
                min = n;
                dpMax[i] = n*n;

            } else if (min <= n ) {
                int  dp = dpMax[i - 1] + min * n;
                if (dp <= n*n){
                    min = n;
                    dpMax[i] = n*n;
                }else{
                    dpMax[i] = dp;
                }
            } else {
                int  dp = (dpMax[i - 1]/min+n)* n;
                if (dp > dpMax[i-1]){
                    dpMax[i] = dp;

                }else{
                    dpMax[i] = n*n;

                }
                min = n;
            }
            max = dpMax[i] > max ? dpMax[i] : max;
        }
        max = dpMax[N - 1] > max ? dpMax[N - 1] : max;
        System.out.println(max);
    }
}
