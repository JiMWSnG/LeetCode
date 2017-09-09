package javaSrc.LeetCodeProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim Wang
 * @create 2017-09-09 17:52
 **/
public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "rgtae"));
    }

    /**
     * 题目描述
     * <p>
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
     * Below is one possible representation of s1 ="great":
     * great
     * /    \
     * gr    eat
     * / \    /  \
     * g   r  e   at
     * / \
     * a   t
     * To scramble the string, we may choose any non-leaf node and swap its two children.
     * For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".
     * rgeat
     * /    \
     * rg    eat
     * / \    /  \
     * r   g  e   at
     * / \
     * a   t
     * We say that"rgeat"is a scrambled string of"great".
     * Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".
     * rgtae
     * /    \
     * rg    tae
     * / \    /  \
     * r   g  ta  e
     * / \
     * t   a
     * We say that"rgtae"is a scrambled string of"great".
     * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     */

    /**
     * 1.判断是否相等
     * 2.字符是否抑制，如果有不一致，直接false
     * 3.分隔字符串，有两种情况，一种是不交换，一种是左右交换。dfs
     * 参考自leetcode网友：@baifriend
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] != 0)
                return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
