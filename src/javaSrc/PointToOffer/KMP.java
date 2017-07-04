package javaSrc.PointToOffer;

/**
 * Created by Jim Wang on 2017/4/20.
 */
public class KMP {
    public static void main(String[] args) {
        String s = "abcdefgabcdefgdasdjvniwnsdfjoqndkwod";
        String f= "abcdef";
        kmpSearch(s,f,getNext(f));
    }
    private static int[] getNext(String f){
        int len = f.length();
        int[] next = new int[len+1];//从1开始到len，表示长度为i的字符串的最大共同前缀后缀长度
        next[0]=next[1] =0;
        //已知next[i]和i求next[i+1]
        int j =next[1];//j=以匹配的长度
        for(int i =1;i<len;i++){
            while(j>0&&f.charAt(i)!=f.charAt(j))
                j=next[j];
            if(f.charAt(i)==f.charAt(j))
                j++;
            next[i+1]=j;
        }
        return next;

    }

    /**
     * 1\每次不匹配，目标字符串f前移，重新计算匹配长度知道j==0，等同于重新开始
     * 2\匹配后，重新赋值j=next[j];
     * 3\初始化j= next[1]=0;
     * 4\ next数组保证next[0]==next[1]==0
     * @param s
     * @param f
     * @param next
     */
    public  static void kmpSearch(String s ,String f,int[ ] next){
        int j= next[1];
        for(int i =0;i<s.length();i++){
            while(j>0&&s.charAt(i)!=f.charAt(j))
                j=next[j];
            if(s.charAt(i)==f.charAt(j))
                j++;
            if(j==f.length()){
                //match
                System.out.println("find at position " + (i - j+1));
                System.out.println(s.subSequence(i - j + 1, i + 1));
                j=next[j];//charAt(len) exception
            }


        }
    }

}
