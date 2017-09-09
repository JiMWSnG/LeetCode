package javaSrc;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-08-19 19:20
 **/
public class random {

    public static void sort(int[] nums) {
        if (nums == null) {
            return;
        }
//        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
    }

    public static void quickSort(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int temp = nums[i];
        while (i < j) {
            while (j > i && nums[j] >= nums[i]) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= nums[j]) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = temp;
    }

    public static int[] removeSame(int[] nums) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        int size = nums.length;
        int[] result = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], true);
                result[j] = nums[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = removeSame(nums);
        sort(result);
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1){
                System.out.println(result[i]);
            }else{
                System.out.print(result[i]);
                System.out.print(" ");
            }
        }

    }

}
