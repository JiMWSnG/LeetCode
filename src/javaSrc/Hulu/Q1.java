package javaSrc.Hulu;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-09-21 19:09
 **/
public class Q1 {
    /**
     * Q1 打印函数调用栈
     时间限制：C/C++语言 1000MS；其他语言 3000MS
     内存限制：C/C++语言 131072KB；其他语言 655360KB
     题目描述：
     给出n个函数（编号1-n），每个函数会执行若干次以下几种语句：1.调用其他函数，用函数编号表示；2.抛出异常，用-1表示；3.返回结果，用0表示，每个函数的最后一定会返回。给出入口函数编号，若会抛出异常，则输出调用栈，从抛出异常的函数直到入口函数；若正常返回，输出R；若无法返回，输出E
     输入
     第一行是两个整数n和k，表示函数个数及入口函数
     接下来n行，每行有若干个整数，表示第i个函数的执行语句，多个语句用空格隔开
     输出
     输出结果为一行，若出现异常，输出调用栈，函数编号间用空格隔开；若正常返回，输出R；若无法返回，输出E

     样例输入
     4 1
     3 4 0
     -1 0
     2 0
     -1 3 0
     样例输出
     2 3 1

     Hint
     输入样例2
     2 1
     0 2 0
     -1 0

     输出样例2
     R
     */
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int k  = sc.nextInt();
        sc.nextLine();
        int[][] array= new int[n][];
        for (int i = 0; i< n; i++){
           String temp = sc.nextLine();
            String[] str = temp.split(" ");
            int size = str.length;
            int[] a = new int[size];
            for (int j = 0;j<size;j++){
                a[j] = Integer.valueOf(str[j]);
            }
            array[i] = a;
        }
        String re = getPath(k, array);
        if(re == "-1"){
            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            re = sb.toString();
            re = sb.substring(0,sb.length()-1);
        }
        System.out.println(re);
    }
    public static String  getPath(int k, int[][] a){

        stack.push(k);
        if (a[k-1] == null){
            return "E";
        }
        int first = a[k-1][0];
        String result ;
        if (first == 0){
           result = "R";
        }else if(first == -1){
            result = "-1";
        }else{
            int n = a[k-1].length;
            if (n ==1){
                a[k-1] =null;
            }else{
                a[k-1] = Arrays.copyOfRange(a[k-1], 1,n);
            }
            result = getPath(first, a);
        }
        return result;
    }

}
