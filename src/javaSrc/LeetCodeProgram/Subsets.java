package javaSrc.LeetCodeProgram;

import java.util.ArrayList;

/**
 * Created by jiwang003746 on 2017/7/14.
 */
public class Subsets {

    public static void main(String[] args) {
        int[] num = {1,2,3};
        new Subsets().subsetsWithDup(num);
    }

    /**
     * 题目描述

     Given a set of distinct integers, S, return all possible subsets.
     Note:
     Elements in a subset must be in non-descending order.
     The solution set must not contain duplicate subsets.

     For example,
     If S =[1,2,3], a solution is:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
     * @param num
     * @return
     */
    // dfs
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(num == null ){
            return  result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        for (int i  =0; i<= num.length; i++){

            subsets(num, 0, i, subset, result);
        }
        return result;

    }

    //[begin,end)
    private void subsets(int[] num, int begin, int k,
                         ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> sets){
        if (begin + k > num.length){
            return;
        }
        if(k ==  0){
            if(!sets.contains(subset)){
                sets.add(new ArrayList<>(subset));
            }
            return;
        }
        for (int i = begin; i<num.length; i++){

            subset.add(num[i]);
           subsets(num,i+1, k-1, subset,sets);
            subset.remove(subset.size() - 1 );

        }
    }


}
