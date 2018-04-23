package javaSrc.Didi;

/**
 * @author Jim Wang
 * @create 2017-09-10 16:28
 **/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(helper(arr));
    }
    public static int helper(int[] arr){
        int[] dp = new int[arr.length+2];
        dp[0] = 0;
        dp[1] = (arr[0] == 0)? 1: 0;
        dp[2] = dp[0] + dp[1];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 0) dp[i+2] = dp[i+1]+1;
            else if(arr[i] == arr[i-1]) dp[i+2] = dp[i+1]+1;
            else dp[i+2]= dp[i+1];
        }
        return dp[dp.length-1];
    }
}