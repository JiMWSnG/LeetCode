package javaSrc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class N_M_K {
    private static Scanner input;
    public static void main(String[] args) {
        int n, k = 0, m = 0;
        input = new Scanner(System.in);
        n = input.nextInt();//输入n的值
        m = input.nextInt();//输入m的值
        k = input.nextInt();//输入k的值
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();//输入数组里的数
        }
        List<Integer> result = new ArrayList<>();
        f(0, k, a, m, result, 0);
        int max =Integer.MIN_VALUE;
        for (int i : result){
            max = max < i ?i:max;
        }
        System.out.println(max);
    }

    static void f(int s, int k, int a[], int m, List<Integer> result, int tmp) {
        if (a.length- s < (m-1)*k+1){
            return;
        }
        if (m ==1){
            int max = Integer.MIN_VALUE;
            for (int i = s; i < a.length; i++){
                max = max < a[i] ?a[i]:max;
            }
            result.add(max+tmp);
        }else{
            for (int i = s; i < a.length; i++){
                f(i+k, k, a, m-1, result, tmp+a[i]);
            }
        }


    }
}