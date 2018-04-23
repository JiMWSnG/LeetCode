package javaSrc.Aiqiyi;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-09-10 19:21
 **/
public class xunhuanshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        long now = System.nanoTime();
        String v1 = repeat(x1, k1);
        String v2 = repeat(x2, k2);
        System.out.println(compareTo(v1, v2));
        System.out.println(System.nanoTime()-now);
    }

    public static String repeat(int x, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            sb.append(String.valueOf(x));
        }
        return sb.toString();
    }

    public static String compareTo(String v1, String v2) {
        int result = 0;
        if (v1.length() > v2.length()) {
            result = 1;
        } else if (v1.length() < v2.length()) {
            result = -1;
        } else {//equals
            for (int i = 0; i < v1.length(); i++) {
                if (v1.charAt(i) - v2.charAt(i) != 0) {
                    result = v1.charAt(i) - v2.charAt(i);
                }
            }
        }
        String res;
        if (result > 0) {
            res = "Greater";
        } else if (result < 0) {
            res = "Less";
        } else {
            res = "Equal";
        }
        return res;
    }
}
