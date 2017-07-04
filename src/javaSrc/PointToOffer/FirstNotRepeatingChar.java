package javaSrc.PointToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jim Wang on 2017/5/25.
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        int re = new FirstNotRepeatingChar().FirstNotRepeatingChar("google");
        System.out.println(re);
    }
    /**
     * 第一个只出现一次的字符
     * <p>
     * 题目描述
     * 在一个字符串
     * (1<=字符串长度<=10000，大小写都有)中找到第一个只出现一次的字符,并返回它的位置
     */

    public int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str))
            return -1;
        Map<String, Integer> map = new HashMap<>();
        char s = 'A';
        for (int i = 0; i < 26; i++) {
            Character tmp = (char) (s + i);
            map.put(tmp.toString(), -1);
        }
        s ='a';
        for (int i = 0; i < 26; i++) {
            Character tmp = (char) (s + i);
            map.put(tmp.toString(), -1);
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            String si = str.toUpperCase().substring(i,i+1);
            Integer num = map.get(si);
            if (num == null) {
                //do nothing
            } else if (num >-1) {
                map.remove(si);//more than once
            } else if (num == -1) {
                map.put(si, i);
            } else {
                //wrong
                return -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            int index = i.getValue();
            if(index>-1){

                min = index<min?index:min;
            }
        }


        return min;

    }
}
