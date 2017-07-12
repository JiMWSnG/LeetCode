package javaSrc.SwardToOffer;

/**
 * Created by jiwang003746 on 2017/6/12.
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.print(new StrToInt().StrToInt("-2147483647"));
    }
    /**
     * 把字符串转换成整数
     *
     * 题目描述
     将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     数值为0或者字符串不是一个合法的数值则返回0
     输入描述:
     输入一个字符串,包括数字字母符号,可以为空


     输出描述:
     如果是合法的数值表达则返回该数字，否则返回0

     输入例子:
     +2147483647
     1a33

     输出例子:
     2147483647
     0
     */

    public int StrToInt(String str) {
        if(str==null|"".equals(str)){
            return 0;
        }
        int size = str.length();
        int result =0;
        boolean ispositive =true;
        for(int i =0;i<size;i++){
            char cur = str.charAt(i);
            //数字0~9
            if((cur-'0')>=0&&(cur-'0')<9){
                    result=result*10+(cur-'0');
            }else if(i==0){
                if(cur=='-'){
                    ispositive=false;
                }else if(cur=='+'){
                    ispositive=true;
                }else{
                    return 0;
                }
            } else{
                return 0;
            }
        }
        if(!ispositive){
            result=~result+1;
        }
        return result;
    }
}
