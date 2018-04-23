package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-08 14:17
 **/
public class SetMatrixZeros {
    /**
     * 题目描述
     Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     click to show follow up.
     Follow up:
     Did you use extra space?
     A straight forward solution using O(m n) space is probably a bad idea.
     A simple improvement uses O(m + n) space, but still not the best solution.
     Could you devise a constant space solution?
     * @param matrix
     */
    public void setZeros(int[][] matrix){
        if (matrix == null){
            return;
        }
        boolean row = false, col = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i =0; i<m;i++ ){
            if (matrix[i][0] == 0){
                row = true;
                break;
            }
        }
        for (int i =0; i<n;i++ ){
            if (matrix[0][i] == 0){
                col = true;
                break;
            }
        }
        for (int i = 1; i< m;i++){
            for (int j =1 ;j< n;j++){
                if (matrix[i][j]== 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i< m;i++){
            for (int j =1 ;j< n;j++){
                if (matrix[i][0]== 0|| matrix[0][j] == 0){
                   matrix[i][j] = 0;
                }
            }
        }
        if (row){
            for (int i =0; i<m;i++ ){
                matrix[i][0]= 0 ;
            }
        }
        if (col){
            for (int i =0; i<n;i++ ){
                matrix[0][i]= 0 ;
            }
        }


    }
}
