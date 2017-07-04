package javaSrc.PointToOffer;

import java.util.*;

/**
 * Created by Jim Wang on 2017/5/9.
 */
public class GetLeastNumbers {
    /**
     * 最小的K个数
     *
     * 题目描述
     输入n个整数，找出其中最小的K个数。
     例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null||input.length<k||k<=0)
            return new ArrayList<Integer>();
        Set<Integer> set = new TreeSet<>();
        int n = input.length;
        for(int i=0;i<n;i++){
            int tmp = input[i];
            if(set.size()==k){
                //find max num .delete and insert new one
               int max = findMax(set);
                if(max>tmp){
                    set.remove(max);
                    set.add(tmp);
                }
            }else if (set.size()<k){
               set.add(tmp);
            }else{
                //wrong
                return null;
            }
        }
        return new ArrayList<Integer>(set);

    }
    private int findMax(Set<Integer> set){
        int result=Integer.MIN_VALUE;
        if(set==null) {
            return result;
        }
        for(Integer i:set){
            result = result>=i?result:i;
        }
        return result;
    }

    private int Partition(int[] array,int length,int start,int end){
        int pick = array[start];
        int j = end;
        int i = start;
        while(i<j){
            while(i<j&&array[j]>=pick)
                j--;
            array[i] = array[j];
            while(i<j&&array[i]<=pick)
                i++;
            array[j] = array[i];
        }
        if(i==j)
            array[j]=pick;
        else
            //error
            System.out.println("wrong");
        return j;
    }

}
