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
    List<TreeNode>ans=new ArrayList<>();
    HashMap<String,Integer>hs=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
    public String solve(TreeNode root){
        if(root==null)return new String("M");
        String left=solve(root.left);
        String right=solve(root.right);
        String curr=root.val+"_"+left+"_"+right;
        if(hs.containsKey(curr))
            hs.put(curr,hs.get(curr)+1);
        else hs.put(curr,1);
        if(hs.get(curr)==2) ans.add(root);
        return curr;
    }
}