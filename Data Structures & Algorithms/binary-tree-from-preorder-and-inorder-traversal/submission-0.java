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
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        //Map to store value -> index mapping for inorder traversal
        //This allows O(1) lookup to find root position
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            inOrderIndexMap.put(inOrder[i], i);
        }

        //Start recursion:
        //preorder index starts at 0 (first element is root)
        // inorder range is full array: 0  to n-1
        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

        private TreeNode splitTree(
            int[] preOrder,
            Map<Integer, Integer> inOrderIndexMap,
            int rootIndex,
            int left,
            int right
    ){
        //Create root node using current preorder index
            TreeNode root = new TreeNode(preOrder[rootIndex]);
            //find root position in inorder array
            int mid =inOrderIndexMap.get(preOrder[rootIndex]);

            // LEFT SUBTREE
            //If there are elements on the left side of root in inorder
            if(mid > left){
                //next preorder index is rootIndex+1
                root.left = splitTree(preOrder, inOrderIndexMap, rootIndex+1, left, mid-1);
            }
            //RIGHT SUBTREE
            //If there are elements on the right side of the root in inorder
            if(mid < right){
                //index of current root in preorder, Number of nodes in the left subtree ,skip the root itself = total skip( root + left subtree )
                int rightRootIndex = rootIndex +(mid-left) +1;
                root.right = splitTree(preOrder, inOrderIndexMap, rightRootIndex, mid+1, right );
            }

                return root;
    }
}
