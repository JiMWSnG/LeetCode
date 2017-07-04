package javaSrc.PointToOffer;

/**
 * Created by Jim Wang on 2017/6/13.
 */
public class Match {
        public static void main(String[] args) {
            char[] str = "aa".toCharArray();
            char[] pattern ="b*".toCharArray();
            System.out.println(new Match().match(str,pattern));
        }
        /**
         * 正则表达式匹配
         *
         * 题目描述
         请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
         而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，
         匹配是指字符串的所有字符匹配整个模式。
         例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
         * */
        public boolean match(char[] str, char[] pattern) {
            if(str==null||pattern==null){
                return false;
            }
            boolean isMatch =false;
            if(pattern.length==0&&str.length==0){
                return true;
            }
            if(pattern.length==0){
                return false;
            }
            if(str.length==0&&pattern.length==2&&pattern[1]=='*'){
                return true;
            }
            //match first str;
            if(str.length!=0&&(str[0]==pattern[0]||pattern[0]=='.')){
                isMatch=true;
            }

            //如果pattern第二个是*则：
            //          1、isMtach=false,str不动，pattern从*后开始match
            //          2、,isMatch =true,str往后移动一位，pattern不动，开始match
            //          2、,isMatch =true,str不动，pattern往后2位，开始match
            //如果pattern第二个不是*则：
            //          1、第一位匹配，str[1],pattern[1]开始match
            //          2、第一位不匹配，return false
            if(pattern.length>=2&&pattern[1]=='*'){
                if(!isMatch){
                    return match(str,String.valueOf(pattern,2,pattern.length-2).toCharArray());
                }else{
                    return match(String.valueOf(str,1,str.length-1).toCharArray(),pattern)
                            ||match(str,String.valueOf(pattern,2,pattern.length-2).toCharArray());
                }
            }else if(pattern.length==1||(pattern.length>=2&&pattern[1]!='*')){
                if(isMatch){
                    return match(String.valueOf(str,1,str.length-1).toCharArray(),String.valueOf(pattern,1,pattern.length-1).toCharArray());
                }else{
                    return false;
                }
            }
            return isMatch;

        }


}
