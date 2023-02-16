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
        int lvl=0; Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return 0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                TreeNode a=q.remove();
                if(a.left!=null)
                    q.add(a.left);
                if(a.right!=null)
                    q.add(a.right);
                size--;
            }
            lvl++;
        }
        return lvl;
    }
}