package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiwang003746 on 2017/7/14.
 */
public class RestoreIpAddress {
    public static void main(String[] args) {
        String s = "0279245587303";
        ArrayList<String> result = new RestoreIpAddress().restoreIpAddresses(s);
        for (String str : result) {
            System.out.println(str);
        }
//        System.out.println("025".equals("25"));

    }

    /**
     * 题目描述
     * <p>
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * For example:
     * Given"25525511135",
     * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        List<String> ips = new ArrayList<>();
        isIp(s, 0, s.length(), 4, ips, result);
        return result;
    }

    //[begin, end)
    private void isIp(String s, int begin, int end, int n, List<String> ips, ArrayList<String> result) {

        if (n == 1) {
            boolean isTrue = isMatch(s.substring(begin, end));
            if (isTrue) {
                ips.add(s.substring(begin, end));
                result.add(arrayToString(ips, "."));
                ips.remove(ips.size() - 1);
            }
        } else {
            int size = end < (begin + 3) ? end : (begin + 3);
            for (int i = begin + 1; i <= size; i++) {
                String first = s.substring(begin, i);
                if (isMatch(first)) {
                    ips.add(first);
                    String second = s.substring(i, end);
                    isIp(s, i, end, n - 1, ips, result);
                    ips.remove(ips.size() - 1);
                }

            }
        }


    }

    private String arrayToString(List<String> ips, String delim) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (String s : ips) {
            if (first) {
                sb.append(s);
                first = false;
            } else {
                sb.append(delim).append(s);
            }
        }
        return sb.toString();
    }

    private boolean isMatch(String subIp) {
        if (subIp == null || subIp.length() == 0) {
            return false;
        }
        Long num = Long.valueOf(subIp);
        if (num <= 255 && num >= 0) {
            return num.toString().equals(subIp);
        }
        return false;
    }
}
