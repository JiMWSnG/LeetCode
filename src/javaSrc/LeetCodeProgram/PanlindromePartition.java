package javaSrc.LeetCodeProgram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jim Wang on 2017/4/5.
 */
public class PanlindromePartition {
    private static  void breakDFS(String s, Set<String > dict, ArrayList<String> result, StringBuilder str){

        if(s==null||s.length()==0)
            result.add(str.toString());

        for(int i =1;i<s.length()+1;i++){
            String stmp =s.substring(0,i);
            if(dict.contains(stmp)){
                str.append(stmp).append(" ");
                breakDFS(s.substring(i),dict,result,str);
                str.delete(str.length()-stmp.length()-1,str.length());

            }
        }
    }
    public static void main(String[] args) {
        String s ="catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        breakDFS(s,dict,result,str);
        for(String s1: result){
            System.out.println(s1);
        }
    }
    private static  boolean isPanlidrome(String str){
        if(str==null||"".equals(str))
            return false;
        int start =0;int end =str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }
    public static void dfs(String s, List<List<String>> result ,List<String > list){

        if("".equals(s)||s==null)
            result.add(new ArrayList<String>(list));
        for(int i=1 ;i<s.length()+1;i++){
            String leftStr = s.substring(0,i);
            String rightStr = s.substring(i);
            if(isPanlidrome(leftStr)){
                list.add(leftStr);
                dfs(rightStr,result,list);
                list.remove(list.size()-1);
            }
        }
    }
    public static int minCutDFS(String s ){
        if(s==null)
            return 0;
        if("".equals(s))
            return 0;
        int size = s.length();
        int min = size;
        for(int i =1;i<size+1;i++){
            String leftStr = s.substring(0,i);
            String rightStr = s.substring(i);

            if(isPanlidrome(leftStr)){
                int minCut =0;
                minCut=1+ minCutDFS(rightStr);
                min = min<minCut?min:minCut;
            }

        }
        return min;


    }

}
