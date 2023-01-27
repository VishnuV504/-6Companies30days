class Solution {
    long mod=1000_000_000+7; 
    public int numberOfWays(int startPos, int endPos, int k) {
        long dp[][]=new long[k+1][3001];
        for(int i=0;i<=k;i++)Arrays.fill(dp[i],-1l);
        return (int)solve(startPos,endPos,k,dp);
    }
    public long solve(int start,int end,int k,long dp[][]){
        if(k<0)return 0;
        if(k==0&&start==end)return 1l;
        if((start-k>end)||(start+k<end))return 0;
        if(dp[k][start+1000]!=-1)return dp[k][start+1000];
        return dp[k][start+1000]=(solve(start+1,end,k-1,dp)+solve(start-1,end,k-1,dp))%mod;
    }
}