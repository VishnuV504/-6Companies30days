class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return totalWays(0,s,dp);
    }
    private int totalWays(int curr, String s,int dp[])
    {
        if(curr==s.length())
            return 1;
        if(curr>=s.length())
            return 0;
        if(dp[curr]!=-1)
            return dp[curr];
        int pickOne=0; int pickTwo=0;
        if(s.charAt(curr)!='0')
            pickOne=totalWays(curr+1,s,dp);
        if(s.charAt(curr)!='0' && curr+1 !=s.length() && (Character.getNumericValue(s.charAt(curr))*10+Character.getNumericValue(s.charAt(curr+1)))<=26)
            pickTwo=totalWays(curr+2,s,dp);
        dp[curr]=pickOne+pickTwo;
        return dp[curr];
    }
}