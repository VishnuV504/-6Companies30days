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
    int count=0; HashMap<TreeNode,Integer>hs=new HashMap<>();
    public int averageOfSubtree(TreeNode root) {
        height(root);
        solve(root);
        return count;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;
        if(root.left==null&&root.right==null){
            count++;
            return root.val;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        if((root.val+left+right)/hs.get(root)==root.val)count++;
        return root.val+left+right;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int left=height(root.left);
        int right=height(root.right);
        hs.put(root,left+right+1);
        return 1+left+right;
    }
}