package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2019/9/18
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        convert("A", 2);
        convert("PAYPALISHIRING", 4);
        convert("PAYPALISHIRING", 3);
    }

    public static String convert(String s, int numRows) {
        if ("".equals(s) ||null ==s){
            return "";
        }
        int size = s.length();
        if (numRows ==1|| size<=numRows){
            System.out.println(s);
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int x = (numRows - 1 - i) * 2;
            int y = i * 2;
            int index = i;
            sb.append(s.charAt(i));
            while (index < size) {
                if (x != 0 && index + x < size) {
                    sb.append(s.charAt(index + x));
                }
                if (y != 0 && index + x + y < size) {
                    sb.append(s.charAt(index + x + y));
                }
                index += x + y;
            }
        }
        System.out.println(sb.toString());
        return sb.toString().trim();
    }
}
