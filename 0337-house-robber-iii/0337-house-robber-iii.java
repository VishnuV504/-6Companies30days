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
    HashMap<String,Integer>dp=new HashMap<>();
    public int rob(TreeNode root) {
        return solve(root,0);
    }
    public int solve(TreeNode root,int flag){
        if(root==null)return 0;
        String key=flag+"-"+root;
        if(dp.containsKey(key))return dp.get(key);
        int ans=0;
        if(flag==0)
            ans=Math.max(root.val+solve(root.left,1)+solve(root.right,1),solve(root.left,0)+solve(root.right,0));
        else
        ans=solve(root.left,0)+solve(root.right,0);
        dp.put(key,ans);
        return ans;
    }
}