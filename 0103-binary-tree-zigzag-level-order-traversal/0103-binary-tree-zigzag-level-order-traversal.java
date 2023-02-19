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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>>ans= new ArrayList<List<Integer>>();
        if(root==null) return ans;
        Queue<TreeNode>queue =new LinkedList<TreeNode>();
        queue.add(root); int count=0;
        while(queue.size()!=0)
        {
            int lvlSize=queue.size();
            List<Integer>li =new ArrayList<>();
            while(lvlSize!=0)
            {
                TreeNode curr=queue.peek();
                    queue.remove();
                if((count&1)==0)
                    li.add(curr.val);
                else
                    li.add(0,curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                lvlSize--;
            }
            ans.add(li);
            count++;
        }
        return ans;

    }
}