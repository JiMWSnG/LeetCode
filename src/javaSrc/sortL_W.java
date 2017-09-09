package javaSrc;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-08-21 19:32
 **/
public class sortL_W {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] L = new int[n];
        int[] W = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
           L[i] = sc.nextInt();
           W[i] = sc.nextInt();
            map.put(L[i], i);
        }
        Arrays.sort(L);
        int max =Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int result  = 1;
        for (int i = 1; i < n; i++) {
            int last = W[map.get(L[i-1])];
            int now = W[map.get(L[i])];
            if (now< last){
                if (last < max){
                    max = last;
                    min = now < min ?now :min;
                    result+=2;
                }else {
                    if (now < min){
                        min = now;
                        result++;
                    }
                }

            }
        }
       System.out.println(result);


    }

}
