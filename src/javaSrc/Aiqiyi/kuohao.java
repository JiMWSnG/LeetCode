package javaSrc.Aiqiyi;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-09-10 19:13
 **/
public class kuohao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = getDepth(str);
        System.out.println(res);
    }


    public static int getDepth(String str){

        Stack<Character> stack = new Stack<>();
        if(str==null){
            return 0;
        }
        int h =0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.empty()){
                    return 0;
                }else{
                    h = stack.size()>h?stack.size():h;
                    stack.pop();
                }
            }
        }
        if(!stack.empty()){
            return 0;
        }else{
            return h;
        }
    }
}
