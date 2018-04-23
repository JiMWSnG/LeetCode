package javaSrc.LeetCodeProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jim Wang
 * @create 2017-10-07 0:14
 **/
public class MinimumWindowSubString {
    /**
     * 题目描述

     Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     For example,
     S ="ADOBECODEBANC"
     T ="ABC"
     Minimum window is"BANC".
     Note:
     If there is no such window in S that covers all characters in T, return the emtpy string"".
     If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     * @param args
     */
    public static void main(String[] args) {
       System.out.println( minWindow("a","a"));
    }
    public static String minWindow(String S, String T){
        if (S == null || T == null || S.length()< T.length())
            return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (int  t = 0;t<T.length(); t++){
            if (!tMap.containsKey(T.charAt(t))){
                tMap.put(T.charAt(t),1 );
            }else{
                int num = tMap.get(T.charAt(t));
                tMap.put(T.charAt(t), num+1);
            }
        }
        int tSize = T.length();
        int left = 0;
        int minLeft = 0;
        int minSize = S.length();
        boolean isMatch = false;
        for (int i = 0; i<S.length();i++){
            char temp = S.charAt(i);
            //第一个窗口
            if (tMap.containsKey(temp) ){
                if ( tMap.get(temp)>0)
                    tSize--;
                tMap.put(temp, tMap.get(temp) - 1);
            }
            while (tSize == 0){
                isMatch =true;
                if (i-left+1<minSize){
                    minLeft = left;
                    minSize = i-left+1;
                }
                if (tMap.containsKey(S.charAt(left))){
                    tMap.put(S.charAt(left), tMap.get(S.charAt(left))+1);
                    if  (tMap.get(S.charAt(left))> 0){
                        tSize++;
                    }
                }
                left++;
            }
        }
        if (!isMatch)
            return "";
        StringBuffer sb = new StringBuffer();
        for (int i = minLeft; i<minLeft+minSize;i++){
            sb.append(S.charAt(i));
        }
        return sb.toString();


    }
}
