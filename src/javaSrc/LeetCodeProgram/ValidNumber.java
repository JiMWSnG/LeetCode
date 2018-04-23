package javaSrc.LeetCodeProgram;



/**
 * @author Jim Wang
 * @create 2017-10-11 21:40
 **/
public class ValidNumber {
    /**
     * 题目描述

     Validate if a given string is numeric.
     Some examples:
     "0"=>true
     " 0.1 "=>true
     "abc"=>false
     "1 a"=>false
     "2e10"=>true
     Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
     .1 => true
     6e10.1 => false
     1. =>  true
     */
    public static void main(String[] args) {
        System.out.println(isNumber("e"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        if (s == null)
            return false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean seenAfterE = false;
        boolean seenNumeric = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur - '0' >= 0 && cur - '0' <= 9) {
                seenNumeric = true;
                seenAfterE = true;
            } else if (cur == '+' || cur == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else if (cur == '.') {
                if (seenDot) {
                    return false;
                }
                seenDot = true;

            } else if (cur == 'e') {
                if (seenE || !seenNumeric)
                    return false;
                seenE = true;
                seenAfterE = false;
                seenDot = false;
            } else {
                return false;
            }
        }
        return seenNumeric && seenAfterE;
    }
}
