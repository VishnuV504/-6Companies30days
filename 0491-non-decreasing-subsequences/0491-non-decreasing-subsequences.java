class Solution {
    Set<List<Integer>>ans = new HashSet<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        solve(0,-101,nums,new ArrayList<Integer>());
        List<List<Integer>>ans2=new ArrayList<List<Integer>>(ans);
        return ans2;
    }
    public void solve(int curr,int prev,int nums[],ArrayList<Integer>li){
        if(curr>=nums.length){
            if(li.size()>=2)
                ans.add(new ArrayList<>(li));
            return;
        }
        solve(curr+1,prev,nums,li);
        if(nums[curr]>=prev){
            li.add(nums[curr]);
            solve(curr+1,nums[curr],nums,li);
            li.remove(li.size()-1);
        }
    }
}