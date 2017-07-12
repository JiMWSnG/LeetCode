package javaSrc.SwardToOffer;



/**
 * Created by jiwang003746 on 2017/6/15.
 */
public class IsNumeric {
    public static void main(String[] args) {
        char[] str= "5e2".toCharArray();
        System.out.print(new IsNumeric().isNumeric(str));
    }
    /**
     *表示数值的字符串
     *
     * 题目描述
     请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    public boolean isNumeric(char[] str) {
        if(str==null||str.length==0){
            return false;
        }
        int point=-1;
        int e= -1;

        for(int i =0;i<str.length;i++){
            if(str[i]=='.'){
                if(point==-1&&e==-1){
                    point=i;
                }else{
                    return false;
                }

            }else if( str[i]=='e'||str[i]=='E'){
                if(e==-1){
                    e=i;
                }else{
                    return false;
                }
            }


        }
        if(point==-1&&e==-1){
                 return isInt(str,0,str.length);
        }else if(point!=-1){
            if(e==-1){
                return isInt(str,0,point)&&isInt(str,point+1,str.length);
            }else{
                return isInt(str,0,point)&&isInt(str,point+1,e)&&isInt(str,e+1,str.length);
            }
        }else{
            return isInt(str,0,e)&&isInt(str,e+1,str.length);
        }

    }

    private boolean isInt(char[] str,int start,int end){
        if(start>=end){
            return false;
        }
        boolean positive =true;
        boolean result=true;
        if(str[start]=='+'){
            positive=true;
            start++;
        }else if(str[start]=='-'){
            positive=false;
            start++;
        }
        for(int i =start;i<end;i++){
            if(!(str[i]>'9'||str[i]<'0')){
                result&=true;
            }else{
                result&=false;
            }
        }
        return result;





    }
}
