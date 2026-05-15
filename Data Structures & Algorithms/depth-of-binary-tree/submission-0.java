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
    public int maxDepth(TreeNode root) {
        // 1. Handle empty tree
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> eleQueue = new LinkedList<>();
        eleQueue.add(root);
        int numberOfLevels = 0;

        while(true){
            //maintain a count of nodes at each level
            int nodeCountAtLevel = eleQueue.size();
            if(nodeCountAtLevel == 0){
                //If we find no nodes at Level, it means tree has ended, so return
                return numberOfLevels;
            }
        //Deque all the nodes present a particular level and add it to the queue
            while(nodeCountAtLevel > 0){
                TreeNode element = eleQueue.poll();

                if(element.left != null){
                    eleQueue.add(element.left);
                }
                if(element.right!= null){
                    eleQueue.add(element.right);
                }
                nodeCountAtLevel--;
            }
            numberOfLevels++;
        }

    }
}
