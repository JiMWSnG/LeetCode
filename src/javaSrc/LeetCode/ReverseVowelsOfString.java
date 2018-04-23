package javaSrc.LeetCode;

public class ReverseVowelsOfString {
    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     *
     * Example 1:
     * Given s = "hello", return "holle".
     *
     * Example 2:
     * Given s = "leetcode", return "leotcede".
     *
     * Note:
     * The vowels does not include the letter "y".
     */

    /***********
     ** right **
     ***********/
    public String reverseVowels(String s) {
        int size = s.length();
        int i = 0;
        int j = size-1;
        char[] chars = s.toCharArray();
        while (i<j){
            while (!isVowel(chars,i) && i < j){
                i++;
            }
            while (!isVowel(chars,j) && i < j){
                j--;
            }
            swap(chars, i, j);
            if (i < j){
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }
    // 判断是够是元音
    private boolean isVowel(char[] s, int i){
        char c = s[i];
        if (c-'a' == 0 || c-'A' == 0){
            return true;
        }
        if (c-'e' == 0 || c-'E' == 0){
            return true;
        }
        if (c-'i' == 0 || c-'I' == 0){
            return true;
        }
        if (c-'o' == 0 || c-'O' == 0){
            return true;
        }
        if (c-'u' == 0 || c-'U' == 0){
            return true;
        }
        return false;
    }
    // 交换
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] =  array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        ReverseVowelsOfString reverseObject = new ReverseVowelsOfString();
        String s = "LeetCode is GOOD!";
        System.out.println(s);
        System.out.println(reverseObject.reverseVowels(s));
    }

}
