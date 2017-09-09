package javaSrc;

import java.util.Scanner;
import java.util.Stack;
/**
 * @author Jim Wang
 * @create 2017-09-08 20:07
 **/
public class kuohaopipei {

    public static boolean isLegal(String str, int[] count){

        Stack<Character> stack = new Stack<>();
        if(str==null){
            return false;
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.empty()){
                    return false;
                }else{
                    count[0] *= stack.size();
                    stack.pop();
                }
            }
        }
        if(!stack.empty()){
            return false;
        }else{
            return true;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = subString(s);
        System.out.println(count);
        int[] nums = new int[1];
        nums[0]=1;
        isLegal(s, nums);
        System.out.println(nums[0]);

    }

    public static int subString(String s){
        if(s.equals("")){
            return 1;
        }
        int result = 0;
        for (int i = 0; i< s.length(); i++){
           if (s.charAt(i) == ')'){
               String temp = s.substring(1,i)+s.substring(i+1);
               if (isLegal(temp,new int[1])){
                   result += subString(temp);
               }
           }
        }
        return result;

    }



}