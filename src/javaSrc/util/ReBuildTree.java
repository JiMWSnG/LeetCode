package javaSrc.util;




import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author jimwong
 * @since 2018/4/14  上午10:30
 */
public class ReBuildTree {
    /**
     * @param src       层序遍历数组
     * @return
     */
    public static TreeNode rebuildTreeByLFS(int[] src){
        Queue<TreeNode> queue = new LinkedList<>();
        if (src == null || src.length == 0){
            return new TreeNode(-1);
        }
        TreeNode root = helper(src, 0);
        return root;

    }
    private static TreeNode helper(int[] src, int i){
        int N = src.length;
        if (i > N){
            return null;
        }
        TreeNode root = new TreeNode(src[i]);

        if (2*i + 1 < N){
            root.left = helper(src, 2*i + 1);
        }else{
            root.left = null;
        }

        if (2*i + 2 < N){
            root.right = helper(src, 2*i + 2);
        }else{
            root.right = null;
        }

        return root;
    }
}
