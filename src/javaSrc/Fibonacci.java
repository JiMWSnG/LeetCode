package javaSrc;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.MemoryHandler;

/**
 * Created by Jim Wang on 2017/3/14.
 */
public class Fibonacci {
    /**
     * 递归实现
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n<0||n>39)
            return -1;
        int result=0;
        if(n==1||n==0){
            result=n;
        }else{
            result=Fibonacci(n-1)+Fibonacci(n-2);
        }
        return result;


    }

    /**
     * 队列的方式输出F(n)
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        if(n<0||n>39)
            return -1;
        if(n<=1){
            return 1;
        }
        int result=0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        queue.offer(1);
        for(int i=2;i<=n;i++){
            int bb = queue.poll();
            int b = queue.peek();
            result = bb+b;
            queue.offer(result);

        }
        return result;

    }
    public static void main(String[] args) {

        int f = Fibonacci1(3);
        System.out.println(f);
    }





}
