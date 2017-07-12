package javaSrc.SwardToOffer;

/**
 * Created by jiwang003746 on 2017/6/12.
 */
public class Sum {
    public static void main(String[] args) {
        System.out.print( new Sum() .Sum_Solution(10));
    }
    public Sum(){
        s[0]=new A();
        s[1]=new B();
    }


    public int Sum_Solution(int n) {
        /**
         *
         * 求1+2+3+...+n
         * 题目描述
         求1+2+3+...+n，
         要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
         */

        return s[flag].sum(n);

    }
    private int flag =1;
    private A[] s = new A[2];

    class A {
        //n==0时调用
        public int sum(int n){
            return 0;
        }
    }
    class B extends A {
        public int sum(int n ){
            flag =~~n;
            int index =Integer.compare(flag,0);
            return s[index].sum(n-1)+n;
        }
    }

}
