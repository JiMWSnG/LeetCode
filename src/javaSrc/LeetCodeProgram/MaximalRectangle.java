package javaSrc.LeetCodeProgram;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Jim Wang
 * @create 2017-09-09 20:09
 **/
public class MaximalRectangle {
    public static void main(String[] args) {

        char[][] matrix = new char[7][4];
        matrix[0][0] = '0';
        matrix[0][1] = '0';
        matrix[0][2] = '1';
        matrix[0][3] = '0';
        matrix[1][0] = '1';
        matrix[1][1] = '1';
        matrix[1][2] = '1';
        matrix[1][3] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '1';
        matrix[2][3] = '1';
        matrix[3][0] = '1';
        matrix[3][1] = '1';
        matrix[3][2] = '1';
        matrix[3][3] = '0';
        matrix[4][0] = '1';
        matrix[4][1] = '1';
        matrix[4][2] = '0';
        matrix[4][3] = '0';
        matrix[5][0] = '1';
        matrix[5][1] = '1';
        matrix[5][2] = '1';
        matrix[5][3] = '1';
        matrix[6][0] = '1';
        matrix[6][1] = '1';
        matrix[6][2] = '1';
        matrix[6][3] = '0';
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));

    }
    /**
     * 题目描述

     Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int max =0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] h = new int[n+1];
        for (int i = 0; i< n+1; i++){
            h[i] = 0;
        }
        for (int i =0;i< m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] =='1'){
                    h[j]++;
                }else{
                    h[j] = 0;
                }
            }
            int temp  = largestRectangleArea(h);
            max = max >temp?max:temp;

        }
        return max;
    }
    public int largestRectangleArea(int[] h){
        if (h == null||h.length == 0){
            return 0;
        }
        h = Arrays.copyOf(h,h.length+1);
        h[h.length-1] = -1;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int area = 0;
        int i =0;
        while (i< h.length){
            if (stack.size() == 0|| h[i]>=h[stack.peek()]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                if (stack.size() == 0){
                    area = h[top]*i;
                }else{
                    area = h[top]*(i-stack.peek()-1);
                }
                max = max>area?max:area;
            }
        }
        return max;
    }

}
