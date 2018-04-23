package javaSrc.Aiqiyi;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-09-10 19:46
 **/
public class pingfanggen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getNum(n, m));
        System.out.println(getNum2  (n, m));
    }

    public static int getNum(int n, int m) {
        int max = n * m;
        int count = 0;
        for (int i = 1; i * i <= max; i++) {

            int pow = i * i;
            for (int j = n; j >0&&pow / j <= m; j--) {
                if (pow % j == 0  ) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int getNum2(int n, int m) {
        int max = n * m;
        int count = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = m; j >0; j--) {
                double sqrt  = Math.sqrt(i*j);
                double det = (sqrt-(int)sqrt);
                if (det==0){
                    count ++;
                }
            }
        }
        return count;
    }
}
