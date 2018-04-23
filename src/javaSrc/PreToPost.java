package javaSrc;

import sun.security.tools.keytool.Resources_sv;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim Wang
 * @create 2017-09-16 20:22
 **/
public class PreToPost {
    public static void main(String[] args) {
        String pre = "abcdefg";
        List<String > re     = constructTree(pre);
        for (String s : re){
            System.out.println(s);
        }
    }

    public static List<String> constructTree(String preOrder){
        List<String> result = new ArrayList<>();
        if (preOrder == null){
            return result;
        }
        if (   preOrder.length()<=1){
            result.add(preOrder);
            return result;
        }
        for (int i =1; i<= preOrder.length();i++){
            List<String> lefts = constructTree(preOrder.substring(1,i));
            List<String>  rights = constructTree(preOrder.substring(i));
            char root = preOrder.charAt(0);
           for (String left: lefts){
               for (String right : rights){
                   String s = left+right+root;
                   if (!result.contains(s))
                       result.add(s);
               }
           }
        }
        return result;
    }
}
