package javaSrc.Meituan;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-09-14 20:33
 **/
public class guandeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lights =new int[n];
        for (int i = 0; i < n; i++){
            lights[i] = sc.nextInt();
        }
        System.out.println(turnOff(lights));

    }
    public static String turnOff(int[] lights){
        int win = 0;
        int n = lights.length;

        for (int i = 0; i< n; i++){
            if ((lights[i]^win) == 1){
                lights[i] = 0;
                win ^= 1;
            }
        }
        if (win == 1){
            return "Alice";
        }else{
            return "Bob";
        }

    }
}
