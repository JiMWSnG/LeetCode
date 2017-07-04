package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Jim Wang on 2017/4/1.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s =s ="catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        WordBreak wb = new WordBreak();
        for(String str : wb.breakDFS(s,dict) ){
            System.out.println(str);
        }
    }

    private List<String> breakDFS(String s,Set<String > dict){
        List<String > result = new ArrayList<>();
        if(s==null||s.length()==0)
            return null;


        for(int i =1;i<s.length();i++){
            String stmp =s.substring(0,i);
            if(dict.contains(stmp)){

                List<String> tmp =(breakDFS(s.substring(i),dict));
                for(String str :tmp){
                    result.add(stmp+" "+str);
                }
            }
        }
        if(dict.contains(s))
            result.add(s)  ;
        return result;


    }
}
