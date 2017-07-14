package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jiwang003746 on 2017/7/14.
 */
public class Subsets {

    public static void main(String[] args) {
        int[] num = {2,2};
        new Subsets().subsetsWithDup(num);
    }
    /**
     * 题目描述

     Given a collection of integers that might contain duplicates, S, return all possible subsets.
     Note:
     Elements in a subset must be in non-descending order.
     The solution set must not contain duplicate subsets.

     For example,
     If S =[1,2,2], a solution is:
     [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
     ]
     */
    // dfs
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(num == null ){
            return  result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(num, 0, num.length, subset, result);
        return result;

    }

    //[begin,end)
    private void subsets(int[] num, int begin, int end,
                         ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> sets){
        if(begin ==  end){
            return;
        }
        for (int i = begin; i<end; i++){

            subset.add(num[i]);
            if(!sets.contains(subset)){
                sets.add(new ArrayList<>(subset));
            }
            subsets(num, i+1, end, new ArrayList<>(), sets);

        }
    }


}
