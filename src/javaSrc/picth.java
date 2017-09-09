package javaSrc;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-08-19 19:49
 **/
public class picth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] apples = new int[10];
        for (int i = 0;i < 10; i++){
            apples[i] = sc.nextInt();
        }
        int ManH = sc.nextInt();
        int chairH = 30;
        int maxH = ManH+chairH;
        int num = 0;
        for (int i = 0;i < 10; i++){
            int appleH = apples[i];
            if (appleH < maxH){
                num ++;
            }
        }
        System.out.println(num);
    }
}
