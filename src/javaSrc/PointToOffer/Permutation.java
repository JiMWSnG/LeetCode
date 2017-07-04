package javaSrc.PointToOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Jim Wang on 2017/5/4.
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation  p = new Permutation();
        p.permutation("aab");



        System.out.println(1);
    }
    /**
     * 字符串的排列
     * 题目描述
     输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     输入描述:
     输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     */
    public ArrayList<String> permutation(String str) {
        ArrayList<String>  dst = new ArrayList<>();
        if(str==null||"".equals(str))
            return dst;
        permutationChar(str.toCharArray(),0,dst);
        Collections.sort(dst, new Comparator<String>(){
            public int compare(String a, String b) {
                int size = a.length();
                for(int i =0;i<size;i++) {
                    if (a.charAt(i) < b.charAt(i))
                        return 1;
                    else if (a.charAt(i) > b.charAt(i))
                        return -1;
                }
                return 0;



            }

        });

        return dst;


    }
    private void permutationChar(char[] str,int i,ArrayList<String> dst){
        if(str==null)
            return ;
        if(!dst.contains(new String(str)))
             dst.add(new String(str));
        for(int j =i+1;j<str.length;j++){
            if(str[j]!=str[i]){
                char tmp = str[j];
                str[j]=str[i];
                str[i]=tmp;
                permutationChar(str,i+1,dst);
                str[i] = str[j];
                str[j]= tmp;
            }else{
                permutationChar(str,i+1,dst);
            }
        }



    }



}
