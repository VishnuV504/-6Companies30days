//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String s)
    {
        // code here
        long[] dp = new long[s.length()+1];
        Arrays.fill(dp,-1l);
        return (int)totalWays(0,s,dp);
        
    }
    private long totalWays(int curr, String s,long dp[])
    {
        long mod=1000_000_000+7;
        if(curr==s.length())
            return 1l;
        if(curr>=s.length())
            return 0l;
        if(dp[curr]!=-1)
            return dp[curr];
        long pickOne=0; long pickTwo=0;
        if(s.charAt(curr)!='0')
            pickOne=totalWays(curr+1,s,dp);
        if(s.charAt(curr)!='0' && curr+1 !=s.length() && (Character.getNumericValue(s.charAt(curr))*10+Character.getNumericValue(s.charAt(curr+1)))<=26)
            pickTwo=totalWays(curr+2,s,dp);
        dp[curr]=(pickOne+pickTwo)%mod;
        return dp[curr];
    }
}