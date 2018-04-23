package javaSrc.LeetCodeProgram;

import java.util.ArrayList;

/**
 * @author Jim Wang
 * @create 2017-10-06 21:21
 **/
public class Combinations {
    /**
     * 题目描述

     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     For example,
     If n = 4 and k = 2, a solution is:
     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
     * @param n
     * @param k
     * @return
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(1, k, n, list, result);
        return result;
    }

    private void dfs(int start, int k, int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (n - start + 1 < k) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(start);
        dfs(start + 1, k - 1, n, list, result);
        list.remove(list.size() - 1);
        dfs(start + 1, k, n, list, result);
    }

}
