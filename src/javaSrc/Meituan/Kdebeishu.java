package javaSrc.Meituan;

import java.util.*;


/**
 * @author Jim Wang
 * @create 2017-08-31 20:05
 **/
public class Kdebeishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        List<List<Integer>> sum = new ArrayList<>();
        sum.add(new ArrayList<>());
        int result = getKDfs(nums, n - 1, k, sum);
        System.out.println(result);
    }

    public static int getKDfs(int[] nums, int start, int k, List<List<Integer>> sum) {

        if (nums == null || start >= nums.length) {
            return 0;
        }
        int max = 0;
        int num = nums[start];
        int last = 0;
        if (start > 0) {
            int tmp = getKDfs(nums, start - 1, k, sum);
            max = max > tmp ? max : tmp;
            last = nums[start - 1];
        }
        List<List<Integer>> sumCopy = new ArrayList<>(sum);
        for (List<Integer> i : sumCopy) {
            int size = i.size();
            if ( size == 0||(start > 0 && i.get(size - 1) == last) ) {
                List<Integer> tmp = new ArrayList<>(i);
                tmp.add(num);
                sum.add(tmp);
            }
            int tmp = i.parallelStream().reduce((a, b) -> a + b).orElse(0) + num;
            if ( tmp % k == 0 && tmp / k >0 ) {
                max = max > (i.size() + 1) ? max : i.size() + 1;
            }
        }
        return max;
    }
}
