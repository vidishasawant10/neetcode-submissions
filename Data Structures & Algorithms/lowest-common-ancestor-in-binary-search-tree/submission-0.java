/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;

        while(node!= null){
            int parentVal = node.val;
            if(pVal >parentVal && qVal > parentVal){
                node = node.right;
            }else if(pVal < parentVal && qVal< parentVal){
                node = node.left;
            }else{
                //they’re on different sides, or one equals parent) → we found the split point = LCA
                return node;
            }
        }
        return null;
    }
}
