class Solution {
    public int jump(int[] nums) {
        int n=nums.length; int dp[]=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--){
                if(j+nums[j]>=i)
                    min=Math.min(dp[j]+1,min);
            }
            dp[i]=min;
        }
        return dp[n-1];
    }
}