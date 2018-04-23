package javaSrc.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author jimwong
 * @since 2018/4/13  下午5:52
 */
public class MostFrequentSubtreeSum {
    /**
     * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
     * <p>
     * Examples 1
     * Input:
     * <p>
     * 5
     * /  \
     * 2   -3
     * <p>
     * return [2, -3, 4], since all the values happen only once, return all of them in any order.
     * <p>
     * Examples 2
     * Input:
     * <p>
     * 5
     * /  \
     * 2   -5
     * <p>
     * return [2], since 2 happens twice, however -5 only occur once.
     * <p>
     * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
     */

    /***********
     ** right ** 最好还是分类放到map里后期好处理，key：sum  ，value; times 记录下maxcount
     ***********/
    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        subTreeSum(root, sums);
        int size = sums.size();
        List<Integer> result = new ArrayList<>();
        Collections.sort(sums);
        int i = 0;
        int max = 0;
        while( i < size){
            int cnt = 0;
            for (int j = i; j < size && sums.get(i).equals(sums.get(j));j++,cnt++);
            if (cnt == max){
                result.add(sums.get(i));
            }

            if (cnt > max){
                result = new ArrayList<>();
                result.add(sums.get(i));
                max = cnt;
            }

            i += cnt;
        }
        int[] a = new int[result.size()];
        for (int index = 0; index < result.size(); index++){
            a[index] = result.get(index);
        }
        return a;

    }

    private int subTreeSum(TreeNode root, List<Integer> sums){
        if (root == null)
            return 0;
        int sum = 0;
        if (root.left != null){
            int left =  subTreeSum(root.left, sums);
            sum += left;

        }
        if (root.right != null){
            int right = subTreeSum(root.right, sums);;
            sum += right;
        }
        sum = sum + root.val;
        sums.add(sum);
        return sum ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left   = new TreeNode(2);
        root.right = new TreeNode(-3);
        new MostFrequentSubtreeSum().findFrequentTreeSum(root);
    }
}