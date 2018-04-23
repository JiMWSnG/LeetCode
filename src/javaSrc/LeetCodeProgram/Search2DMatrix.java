package javaSrc.LeetCodeProgram;

import javaSrc.AboutString;

/**
 * @author Jim Wang
 * @create 2017-10-07 23:53
 **/
public class Search2DMatrix {
    /**
     * 题目描述

     Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.

     For example,
     Consider the following matrix:
     [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target =3, returntrue.
     * @param args
     */
    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        int[][] m = {{1,3}};
       boolean t=  s.searchMatrix(m, 1);
        System.out.println(t);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null){
            return false;
        }
        int m  = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i>=0 && j>=0 && i<m && j< n){
            int temp = matrix[i][j];
            if (temp> target){
                j--;
            }else if( temp< target){
                i++;
            }else{
                return true;
            }

        }
        return false;
    }
}
