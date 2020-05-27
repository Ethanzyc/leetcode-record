//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q) {
            return root;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        preOrder(root, map);

        List<TreeNode> parentP = findParent(p, map, root);
        List<TreeNode> parentQ = findParent(q, map, root);
        for (int i = 0; i < parentP.size(); i++) {
            for (int j = 0; j < parentQ.size(); j++) {
                if (parentP.get(i) == parentQ.get(j)) {
                    return parentP.get(i);
                }
            }
        }
        return root;
    }

    private static List<TreeNode> findParent(TreeNode p, Map<TreeNode,TreeNode> map, TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(p);
        while (true) {
            TreeNode treeNode = map.get(p);
            if (treeNode == root) break;
            list.add(treeNode);
            p = treeNode;
        }
        return list;
    }

    public static void preOrder(TreeNode root, Map<TreeNode, TreeNode> container){
        if(root!=null){
            if (root.left != null) {
                container.put(root.left, root);
            }
            preOrder(root.left, container);
            if (root.right != null) {
                container.put(root.right, root);
            }
            preOrder(root.right, container);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}

class Solution235fu {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
