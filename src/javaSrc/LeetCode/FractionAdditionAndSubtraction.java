package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author jimwong
 * @since 2018/4/14  下午12:29
 */
public class FractionAdditionAndSubtraction {
    /**
     * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
     *
     * Example 1:
     *
     * Input:"-1/2+1/2"
     * Output: "0/1"
     *
     * Example 2:
     *
     * Input:"-1/2+1/2+1/3"
     * Output: "1/3"
     *
     * Example 3:
     *
     * Input:"1/3-1/2"
     * Output: "-1/6"
     *
     * Example 4:
     *
     * Input:"5/3+1/3"
     * Output: "2/1"
     *
     * Note:
     *
     *     The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
     *     Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
     *     The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
     *     The number of given fractions will be in the range [1,10].
     *     The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
     */


    /***********
     ** right ** keypoint : split(正则) 和gcd(a, b)欧几里得算法
     ***********/
    public static void main(String[] args) {
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition("-1/2+1/2"));
    }

    public String fractionAddition(String expression) {
        List<Fraction> list = praseFractionString(expression);
        Fraction first = new Fraction();
        for (Fraction second : list){
            first = computeFraction(first, second);
        }

        return first.toString();

    }

    private List<Fraction> praseFractionString(String expression){
        List<Fraction> list = new ArrayList<>();
        Fraction fraction = new Fraction();
        int tmp = 0;
        int N = expression.length();
        for (int i = 0; i < N; i++){
            char cur = expression.charAt(i);
            if (cur - '0' < 10 && cur - '0' >= 0){
                tmp = 10 * tmp + cur - '0';
            }
            if (cur == '/'){
                fraction.numerator = tmp;
                tmp = 0;
            }
            if (cur == '-' || cur == '+'){
                fraction.denominator = tmp;
                tmp = 0;
                if (i != 0){
                    list.add(fraction);
                }

                fraction = new Fraction();
                fraction.sign = cur == '-' ? -1 : 1;
            }
        }
        // last
        fraction.denominator = tmp;
        list.add(fraction);

        return list;
    }
    // 分母在[1, 10]，约分只好旅因子2， 3， 5
    private Fraction computeFraction(Fraction a, Fraction b){
        int factor = 1;
        Fraction result = new Fraction();
        // 分数计算
        result.numerator = a.sign * a.numerator * b.denominator + b.sign * b.numerator * a.denominator;
        result.denominator = a.denominator * b.denominator;
        if (result.numerator < 0){
            result.sign = -1;
            result.numerator *= result.sign;
        }else{
            result.sign = 1;
        }
        // 约分
        int n = result.numerator;
        int d = result.denominator;
        factor = gcd(d, n);
        result.numerator = n / factor;
        result.denominator = d / factor;
        return result;

    }
    // 欧几里得算法
    private int gcd(int x, int y) { return  y == 0 ? x : gcd(y, x % y); }

    private class Fraction{
        public int sign;
        public int numerator;
        public int denominator;

        public Fraction(){
            sign = 1;
            numerator = 0;
            denominator = 1;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            if (sign == -1){
                sb.append("-");
            }
            sb.append(numerator).append("/").append(denominator);
            return  sb.toString();
        }
    }


}
