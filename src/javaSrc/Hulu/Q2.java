package javaSrc.Hulu;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-09-21 20:10
 **/
public class Q2 {
    /**
     * Q2 合格的图书馆管理员
     时间限制：C/C++语言 1000MS；其他语言 3000MS
     内存限制：C/C++语言 8192KB；其他语言 532480KB
     题目描述：
     小轩热衷于进行穿越，常年奔波于各个时空之中。这一天的穿越有些无趣，小轩只穿越到了上个世纪，成了湖南某图书馆的管理员。更糟糕的是，小轩发现前一个罢工中的管理员整理书籍非常粗心，将图书编号进行排序时竟然采取了简单的字典序——将数字当作字符串按照字符自前到后进行排列。对于1~12的例子，排序是1，10，11，12，2，3……
     幸好小轩穿越时带着计算机，于是小轩尝试实现一个简单的计算方法，能够迅速找到这套排序下的第n本书的编号。下面请扮演小轩完成这个任务吧。
     输入
     输入第一行为m,n(n<=m<=10^20，空格隔开)，表示求书籍编号为1~m时，第n本书的编号。
     输出
     输出该书的编号n。

     样例输入
     12 3
     样例输出
     11

     Hint
     输入样例2
     1567582787715753216 1567582787715753216

     输出样例2
     999999999999999999
     */




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();
        System.out.println(func(m, n));

    }
    public static long func(long m, long n){
        long cur = 1;
        long count = 1;
        while(count < n){
            if (cur*10 > m|| cur*10<0){
                long in =Math.min(m-cur,9);
                if (count+in >=n){
                    cur += n-count;
                    count = n;
                }else{
                    count +=in;
                    cur =cur/10+1;
                }

            }else{
                count++;
                cur = cur*10;
            }
        }
        return cur;

    }
}
