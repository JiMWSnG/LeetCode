package javaSrc.LeetCode;

import java.util.Stack;

/**
 * @Author jimwong
 * @since 2018/4/12  下午1:10
 */
public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */


    /***********
     ** right **
     ***********/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(new Character(c));
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if (isMatch(top, c)){
                    stack.pop();
                }else{
                  return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private boolean isMatch(char left, char target){
        boolean result = false;
        if (target == ')' && left =='('){
            result = true;
        }
        if (target == ']' && left =='['){
            result = true;
        }
        if (target == '}' && left =='{'){
            result = true;
        }
        return result;
    }
}
