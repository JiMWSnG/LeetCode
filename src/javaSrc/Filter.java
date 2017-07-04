package javaSrc;

import java.util.Scanner;

/**
 * Created by Jim Wang on 2017/4/26.
 */
public class Filter {
    public static  int filter(String match,String pattern){
        if(match ==null|| pattern==null)
            return 0;
        if(pattern=="?"&&match.length()!=1)
            return 0;
        if("".equals(match)||"".equals(pattern)){
            if(pattern.equals(match))
                return 1;
            return 0;
        }
        int size = match.length();
        int j =0;
        for(int i=0;i<size;i++,j++){
            char tmp = pattern.charAt(j);
            if(tmp=='?'){
                if(pattern.length()==j+1&&size == i+1)
                    return 1;
                return filter(match.substring(i+1),pattern.substring(j+1));
            }
            if(tmp=='*'){
                if(pattern.length()==j+1)
                    return 1;
                while(i<size&&match.charAt(i)!=pattern.charAt(j+1))
                    i++;
                if(i==size)
                    return 0;
                return filter(match.substring(i),pattern.substring(j+1));
            }
            if(match.charAt(i)!=tmp)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String match = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(filter(match,pattern));
    }
}
