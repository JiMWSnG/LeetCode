package javaSrc.LeetCode;

import java.util.ArrayList;


/**
 * Created by jiwang003746 on 2017/6/19.
 */
public class PascalsTriangle {
    public static void main(String[] args) {
//        new PascalsTriangle().getRow(3);
        new PascalsTriangle().generate(1);

    }
    /**
     *
     * pascals-triangle-ii
     *
     * 题目描述

     Given an index k, return the k th row of the Pascal's triangle.
     For example, given k = 3,
     Return[1,3,3,1].
     Note:
     Could you optimize your algorithm to use only O(k) extra space?
     */
    public ArrayList<Integer> getRow(int rowIndex) {
        int last = rowIndex+1;
        int[] result = new int[last];
        for (int i =0; i<last; i++){
            result[i] =0;
        }
        for(int i = 0;i<=rowIndex;i++){
            int left =result[0];
            for(int j =0;j<=i;j++){
                if(j==0||j==i){
                    result[j] = 1;
                }else{
                    int right =result[j];
                    result[j] +=left;
                    left =right;
                }
            }
        }
        ArrayList<Integer> re = new ArrayList<>();
        for (int i =0; i<last; i++){
            re.add(result[i]);
        }

        return re;
    }

    /**
     * 题目描述

     Given numRows, generate the first numRows of Pascal's triangle.
     For example, given numRows = 5,
     Return
     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]
     */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 1;i<=numRows;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            int left =1;
            for(int j =0;j<i;j++){
                if(j==0||j==i-1){
                   tmp.add(1);
                }else{
                    int right =row.get(j);
                    tmp.add(left+right);
                    left =right;
                }
            }
            result.add(tmp);
            row = tmp;

        }
        return  result;

    }

}
