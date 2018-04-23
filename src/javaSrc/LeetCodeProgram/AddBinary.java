package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-12 15:05
 **/
public class AddBinary {
    public static void main(String[] args) {
        String re = addBinary("1", "111");
        System.out.println(re);
    }

    /**
     * 题目描述
     * <p>
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a ="11"
     * b ="1"
     * Return"100".
     */
    public static String addBinary(String a, String b) {
        if (a == null || b == null)
            return null;
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        int lenA = a.length();
        int lenB = b.length();
        int c = 0;
        int len = lenA < lenB ? lenA : lenB;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int ca = a.charAt(lenA - 1 - i) - '0';
            int cb = b.charAt(lenB - 1 - i) - '0';
            int cur = (ca + cb + c) % 2;
            c = (ca + cb + c) / 2;
            sb.append(cur);
        }
        String left;
        if (lenA > lenB) {
            left = a.substring(0, lenA - len);
        } else {
            left = b.substring(0, lenB - len);
        }
        for (int i = 0; i < left.length(); i++) {
            int t = left.charAt(left.length() - 1 - i) - '0';
            int cur = (t + c) % 2;
            c = (t + c) / 2;
            sb.append(cur);
        }
        if (c == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
