package javaSrc;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-09-05 20:22
 **/
public class HappyCake {
    public static void main(String[] args) {
        List<List<Integer>> choiceList = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);

        choiceList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(2);
        choiceList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(4);
        choiceList.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(4);
        choiceList.add(tmp);

        HappyCake happyCake = new HappyCake();
        System.out.println(happyCake.findMaxHappyFrnd(2, 2, 4, choiceList));

    }

    int findMaxHappyFrnd(int rows, int columns, int numOfFriends,
                         List<List<Integer>> choiceList) {
        int n = rows * columns;
        int[] dp = new int[numOfFriends + 1];//1-K
        dp[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 1; i <= numOfFriends; i++) {
            List<Integer> choices = choiceList.get(i - 1);
            for (int j = 0; j < choices.size(); j++) {
                int choice = choices.get(j);
                if (choice <= n&&!map.containsKey(choice)) {
                    size++;
                    map.put(choice, 1);
                }
            }
            if (size >= i) {
                dp[i] = dp[i - 1] + 1;

            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numOfFriends] > n ? n:dp[numOfFriends];
    }
}
