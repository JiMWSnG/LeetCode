package javaSrc.LeetCodeProgram;

import java.util.*;


/**
 * @author Jim Wang
 * @create 2017-10-08 15:16
 **/
public class SimplifyPath {
    /**
     * 题目描述
     Given an absolute path for a file (Unix-style), simplify it.
     For example,
     path ="/home/", =>"/home"
     path ="/a/./b/../../c/", =>"/c"
     click to show corner cases.
     Corner Cases:

     Did you consider the case where path ="/../"?
     In this case, you should return"/".
     Another corner case is the path might contain multiple slashes'/'together, such as"/home//foo/".
     In this case, you should ignore redundant slashes and return"/home/foo".
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(simplifyPath("/.."));
    }
    public static  String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] files = path.split("/");
        for (String index : files){
            if ("..".equals(index) ){
                if (!stack.empty()){
                    stack.pop();
                }
            }else if(!".".equals(index) && !"".equals(index)){
                stack.push(index);
            }
        }
        List<String> list = new ArrayList<>();
        while (!stack.empty()){
            String s = stack.pop();
            list.add(s);
        }
        if (list.size() == 0){
            return "/";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = list.size()-1;i>=0;i--){
            sb.append("/").append(list.get(i));
        }
        return sb.toString();
    }
}
