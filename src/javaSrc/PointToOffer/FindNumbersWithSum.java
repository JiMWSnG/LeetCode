package javaSrc.PointToOffer;
import java.util.*;

/**
 * Created by Jim Wang on 2017/6/4.
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        new FindNumbersWithSum().FindNumbersWithSum(a,15);
    }
    /**
     * 和为S的两个数字
     *
     * 题目描述
     输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     输出描述:
     对应每个测试案例，输出两个数，小的先输出。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer first=null,second=null;
        for(int i =0;i<array.length;i++){
            int big = array[i];
            Integer small = map.get(big);
            if(small==null)
                map.put(sum-big,big);
            else{//find
                if(first!=null&&second!=null){
                    if(first*second>small*big){//get the smallest
                        first = small;
                        second = big;
                    }
                }else{
                    first = small;
                    second = big;
                }

            }


        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(first!=null){
            result.add(first);
            result.add(second);
        }

        return result;
    }
}
