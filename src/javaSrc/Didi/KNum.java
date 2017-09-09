package javaSrc.Didi;

import java.util.*;

public class KNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int[] nums = new int[inputs.length];
        for (int i = 0; i< inputs.length; i++){
            nums[i] = Integer.valueOf(inputs[i]);
        }
        int k = inputs.length - sc.nextInt();

        System.out.println(getKMaxNum(nums, k));
        int res = nums[getKNum(nums, k, 0, nums.length - 1)];
        System.out.println(res);

    }

    public static int getKNum(int[] array , int k, int start,int end){
        if (array == null){
            return -1;
        }
        int index = partition(array, start ,end);
        while (index != k){
            if (index > k){
                index = partition(array,start, index - 1 );
            }else{
                index = partition(array, index + 1, end);
            }
        }
        return index;

    }

    private static int partition(int[] array, int start,int end){
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

    public static String getKMaxNum(int [] input, int k) {
        if(input==null||input.length<k||k<=0)
            return "";
        Set<Integer> set = new TreeSet<>();
        int n = input.length;
        for(int i=0;i<n;i++){
            int tmp = input[i];
            if(set.size()==k){
                //find max num .delete and insert new one
                int min = findMin(set);
                if(min < tmp){
                    set.remove(min);
                    set.add(tmp);
                }
            }else if (set.size()<k){
                set.add(tmp);
            }else{
                //wrong
                return "";
            }
        }
        return  String.valueOf(findMin(set));

    }
    private static int findMin(Set<Integer> set){
        int result=Integer.MAX_VALUE;
        if(set==null) {
            return result;
        }
        for(Integer i:set){
            result = result>=i?i:result;
        }
        return result;
    }
}