package javaSrc.PointToOffer;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Jim Wang on 2017/4/21.
 */
public class SubTree {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    /**
     * 二叉搜索树与双向链表
     *
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode convert(TreeNode root){
        TreeNode last = convertNdoe(root,null);
        while(last!=null&&last.left!=null){
            last = last.left;
        }
        return last;

    }
    //关键是通过一个变量保存最后一个节点，使得stack中能共享这个变量
    //1、传参；2、 全局变量，静态变量；3、对象属性
    private TreeNode convertNdoe(TreeNode root,TreeNode last){
        if(root==null)
            return null;
        if(root.left!=null){
            last = convertNdoe(root.left,last);
        }
        if(last!=null){
            last.right = root;
            root.left= last;
        }
        last = root;
        if(root.right!=null){
            last = convertNdoe(root.right,last);
        }
        return  last;

    }

    /**
     * 树的子结构
     *
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param a
     * @param b
     * @return
     */

     public boolean isSubTree(TreeNode a,TreeNode b){
         if(a==null||b==null)
             return false;
         if(a.val==b.val&&isEqual(a,b))
             return true;
         return isSubTree(a.left,b)||isSubTree(a.right,b);
     }

     private boolean isEqual(TreeNode root1,TreeNode root2){
         if(root2==null)
             return true;
         if(root1==null)
             return false;

         if(root1.val!=root2.val)
             return false;
         return isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
     }
}
