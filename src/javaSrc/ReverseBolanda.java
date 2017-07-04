package javaSrc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jim Wang on 2017/4/26.
 */
public class ReverseBolanda {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }
    // write your code here
    public static int resolve(String expr) {
        Stack<Integer> s=new Stack<Integer>();
        int size =0;
        for (int i=0;i<expr.length();i++){
            if(expr.charAt(i)=='+'){
                int right,left;
               try{
                    right=s.pop();
                    left=s.pop();
               }catch (Exception e){
                   return -1;
                }
                int result=left+right;
                s.push(result);
                size--;
            }else if(expr.charAt(i)=='*'){
                int right,left;
                try{
                    right=s.pop();
                    left=s.pop();
                }catch (Exception e){
                    return -1;
                }
                int result=left*right;
                s.push(result);
                size--;
            }else if(expr.charAt(i)=='^'){
                int result;
                try{
                     result = s.pop()+1;
                }catch (Exception e ){
                    return -1;
                }
                s.push(result);
            } else if(expr.charAt(i)==' '){

            }else{
                    if(size<16){
                        s.push(Integer.parseInt(expr.substring(i,i+1)));
                        size++;
                    }
                else
                    return -2;
            }
        }
        return s.pop();
    }
}

