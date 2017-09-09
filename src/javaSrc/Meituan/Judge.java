package javaSrc.Meituan;
import java.util.*;
/**
 * @author Jim Wang
 * @create 2017-08-31 21:03
 **/
public class Judge {
    public static void main(String[] args){
        if(test()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static  boolean test(){
        int max = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > max) max = arr[i];
            map.put(arr[i],map.get(arr[i])==null? 1:map.get(arr[i])+1);
        }
        if(map.get(max) > 1) return true;
        return false;
    }
}
