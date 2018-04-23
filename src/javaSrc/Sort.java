package javaSrc;

import java.util.Stack;

/**
 * Created by Jim Wang on 2017/3/15.
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {7,6,5,7,3,2,7};
        QuickSort2(a, 0,6);
        int[] b = a;

    }
    /**
     * 快速排序
     * @param r
     * @param i
     * @param j
     * @return
     */
    public static int[] QuickSort(int[] r,int i,int j){
        if(r==null||r.length<=0||i<0||j<0){
            return null;
        }
        if(i<j){
            int pivot = partition(r,i,j);
            QuickSort(r,i,pivot-1);
            QuickSort(r,pivot+1,j);
        }
        return r;


    }

    /**
     * 非递归的快排
     * @param r
     * @param i
     * @param j
     * @return
     */
    public static int[] QuickSort2(int[] r, int i ,int j){
        if(r==null||r.length<=0||i<0||j<0){
            return r;
        }
        Stack<Integer> st = new Stack<>();
        if(i<j){
            int mid=partition(r,i,j);
            if(i<mid-1){
                st.push(i);
                st.push(mid-1);
            }
            if(mid+1<j){
                st.push(mid+1);
                st.push(j);
            }
            //其实就是用栈保存每一个待排序子串的首尾元素下标，下一次while循环时取出这个范围，对这段子序列进行partition操作
            while(!st.empty()){
                int high= st.pop();
                int low= st.pop();
                mid=partition(r,low,high);
                if(low<mid-1){
                    st.push(low);
                    st.push(mid-1);
                }
                if(mid+1<high){
                    st.push(mid+1);
                    st.push(high);
                }
            }
        }
        return r;
    }
    private static int partition(int[] r, int i, int j){
        if(r==null||r.length<=0||i<0||j<0){
            return -1;
        }
        int pivot = r[i];
        while(i<j){
            while(i<j&&pivot<=r[j]){
                j--;
            }
            r[i]= r[j];
            while(i<j&&pivot>=r[i]){
                i++;
            }
            r[j]=r[i];
        }
        r[i] =pivot;
        return i;
    }
}
