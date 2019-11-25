package javaSrc.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author jimwong
 * @since 2018/5/8
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Examples:
     * <p>
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * <p>
     * Given "bbbbb", the answer is "b", with the length of 1.
     * <p>
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        int size = s.length();
        //[from,to)
        int from = 0, to = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (to < size) {
            char cur = s.charAt(to);
            if (map.containsKey(cur)) {
                int subLen = to - from;
                max = max > subLen ? max : subLen;
                from = remove(map, from, map.get(cur), s) + 1;
            }
            map.put(cur, to);
            to++;
        }
        return max > to - from ? max : to - from;
    }

    private int remove(Map<Character, Integer> map, int from, int to, String s) {
        while (from <= to) {
            char cur = s.charAt(from);
            map.remove(cur);
            from++;
        }
        return to;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
