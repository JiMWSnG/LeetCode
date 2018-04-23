package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-09 13:25
 **/
public class Sqrt {
    /**
     * 题目描述

     Implementint sqrt(int x).
     Compute and return the square root of x.


     牛顿逼近法
     x(k+1） = (x(k)+n/x(k))/2
     * @param x
     * @return
     */
    public int sqrt(int x) {
        long r = x;
        while(r*r > x)
            r = (r + x/r)>>1;
        return (int)r;

    }
}
