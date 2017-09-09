package javaSrc;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-08-09 22:32
 **/
public class dizhujintiao {

    static int cut(int[] parts) {
        if (parts == null) {
            return 0;
        }
        int total = parts.length;
        List<Integer> partList = new ArrayList<>();
        for (int i : parts) {
            if (i == 1) {
                partList.add(i);
            }
        }

        Collections.sort(partList);
        return getCount(total, partList);
    }

    static int getCount(int total, List<Integer> partList) {
        if (partList == null) {
            return 0;
        }
        int count = partList.size();
        if (count == 1) {
            return 0;
        }
        int max = 0;
        if (count % 2 == 1) {
            max = partList.get(count - 1);
            partList.remove(max);

        }
        return total + getCount(total - max, partList);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }


}
