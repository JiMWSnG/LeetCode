package javaSrc.LeetCodeProgram;

/**
 * @author Jim Wang
 * @create 2017-10-07 21:58
 **/
public class SortColors {
    /**
     * 题目描述
     Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     Note:
     You are not suppose to use the library's sort function for this problem.
     click to show follow up.
     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     Could you come up with an one-pass algorithm using only constant space?
     * @param args
     */
    public static void main(String[] args) {
        SortColors sc =new SortColors();
        int[] a = {1,0};
        sc.sortColors(a);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public void sortColors(int[] A){
        if (A == null || A.length ==0){
            return ;
        }
        int i= 0;
        int j= A.length-1;
        int k =0;
        while (k<=j){
            if (A[k]==0) {
                int temp = A[i];
                A[i] = A[k];
                A[k] = temp;
                i++;
                k++;
            }else if (A[k] == 2){
                int temp = A[j];
                A[j] = A[k];
                A[k] = temp;
                j--;
            }else{
                k++;
            }
        }


    }
    public int quickSort(int[] A){
        if (A== null){
            return -1;
        }
        int i = 0;
        int j = A.length;
        int temp = A[0];
        while (i<j){
            if (i<j &&j >= temp){
                j--;
            }
            A[i] = A[j];
            if (i<j && i<= temp){
                i++;
            }
            A[j] =A[i];
        }
        A[i]= temp;
        return i;
    }
}
