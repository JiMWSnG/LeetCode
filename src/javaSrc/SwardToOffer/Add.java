package javaSrc.SwardToOffer;

/**
 * Created by jiwang003746 on 2017/6/12.
 */
public class Add {

    public static void main(String[] args) {
        System.out.print(new Add().Add(11,7));
    }
    /**
     * 不用加减乘除做加法
     *
     * 题目描述
     写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public int Add(int num1,int num2) {
        int sum =num1^num2;//无进位
        //c进位
        int c = (num1&num2)<<1;
        while(c!=0){
            int tmp = sum^c;
            c =(sum&c)<<1;
            sum =tmp;
        }
        return sum;
    }
}
