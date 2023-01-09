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
    List<Integer>li=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        solve(root);
        return li;
    }
    public void solve(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        if(root!=null)
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            li.add(curr.val);
            if(curr.right!=null)
                st.add(curr.right);
            if(curr.left!=null)
                st.add(curr.left);
        }
    }
}