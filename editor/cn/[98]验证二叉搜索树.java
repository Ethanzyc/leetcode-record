//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution98 {
    public static boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        List<Integer> container = new ArrayList<>();
        preOrder(root, container);
        System.out.println(container);
        for (int i = 0; i < container.size() - 1; i++) {
            if (container.get(i)>container.get(i+1)) {
                return false;
            }
        }

        return true;
    }

    public static void preOrder(TreeNode root, List<Integer> container){
        if(root!=null){
            preOrder(root.left, container);
            container.add(root.val);
            preOrder(root.right, container);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-1);
        System.out.println(isValidBST(treeNode));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
