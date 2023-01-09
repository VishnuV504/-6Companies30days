class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        dp[1]=1l;long mod=1000_000_000+7;
        for(int i=2;i<=n;i++){
            long ans=0l;
            for(int j=i-delay;j>=0&&j>i-forget;j--)
                ans=(ans+dp[j])%mod;
            dp[i]=ans;
        }
        long total=0l;
        for(int i=n-forget+1;i<=n;i++)
            total=(total%mod+dp[i])%mod;
        return (int)total;
    }
}