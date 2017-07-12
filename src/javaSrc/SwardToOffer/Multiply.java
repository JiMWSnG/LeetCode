package javaSrc.SwardToOffer;

/**
 * Created by jiwang003746 on 2017/6/12.
 */
public class Multiply {
    /**
     *
     * 构建乘积数组
     *
     * 题目描述
     给定一个数组A[0,1,...,n-1],
     请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     不能使用除法
     B0      1   A1  A2  `  An-2  An-1
     B1      A0  1   A2  `  An-2  An-1
     `       A0  A1  1   `    `    `
     `        `  `  `    `    `    `
     `       A0  A1  A2  1  An-2  An-1
     Bn-2    A0  A1  A2  `  1     An-1
     Bn-1    A0  A1  A2  `  An-2   1
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
