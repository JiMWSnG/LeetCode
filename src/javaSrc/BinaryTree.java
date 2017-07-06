package javaSrc;

/**
 * Created by Jim Wang on 2017/3/15.
 */
public class BinaryTree {

    int val;
    BinaryTree left;
    BinaryTree right;
    BinaryTree(int x) { val = x; }

  public static  int MinDEpth(BinaryTree root){
      if(root==null){
          return 0;
      }
      int h =0;
      int lh=0,rh=0;
      if(root.left==null&&root.right==null){
            h++;
            return h;
      }
      if(root.left!=null){
         lh=MinDEpth(root.left);
      }
      if(root.right!=null){
          rh =MinDEpth(root.right);
      }
      h+=lh<rh?lh:rh;
      return h;
  }

    /**寻找最近共同祖先
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public static BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree node1, BinaryTree node2) {
        if (root == null) return null;
        if (root == node1 || root == node2) return root;

        BinaryTree left_result = lowestCommonAncestor(root.left, node1, node2);
        BinaryTree right_result = lowestCommonAncestor(root.right, node1, node2);

        if (left_result != null && right_result != null) return root;
        else if (left_result == null && right_result != null) return right_result;
        else return left_result;
    }
}
