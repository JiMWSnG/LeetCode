package javaSrc.LeetCode;

import java.util.ArrayList;

/**
 * Created by jiwang003746 on 2017/6/19.
 */
public class Triangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        triangle.add(row);
        row = new ArrayList<>();
        row.add(2);
        row.add(3);
        triangle.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(-1);
        row.add(-3);
        triangle.add(row);
        new Triangle().minimumTotal(triangle );

    }
    /**
     *
     * triangle
     *
     * 题目描述

     Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     For example, given the following triangle
     [
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
     ]

     The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
     Note:
     Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        int last = triangle.get(row-1).size();
        int[] mins = new int[last];
        for(int i = 0; i<last; i++){
            mins[i] = 0;
        }
        for(int i = 0;i<row;i++){
            ArrayList<Integer> list = triangle.get(i);
            int left =mins[0];
            for (int j = 0;j<list.size();j++){
                if(j==0 || j == list.size()-1){
                    mins[j] = list.get(j)+left;
                } else{
                    int right = mins[j];
                    if(left<right){
                        mins[j] = left+list.get(j);
                        left=right;
                    }else{
                        left=right;
                        mins[j] = right+list.get(j);
                    }
                }
            }
        }
        int min =Integer.MAX_VALUE;
        for(int i = 0;i<last;i++){
            min = min<mins[i]?min:mins[i];
        }
        return min;
    }

}
