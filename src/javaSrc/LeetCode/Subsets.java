package javaSrc.LeetCode;

/**
 * @author Jim Wang
 * @create 2017-10-04 22:10
 **/
import java.util.*;
public class Subsets {
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
    public static void main(String[] args) {
        int[] s = {1,2,3};
        subsets(s);

    }
    //lfd做法
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
         Arrays.sort(S);
       int[] s= S;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0;i<s.length; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (ArrayList<Integer> list : result ){
                ArrayList<Integer> t  = new ArrayList<>(list);
                t.add(s[i]);
                temp.add(t);
            }
            result.addAll(temp);
        }
        return result;
    }
}