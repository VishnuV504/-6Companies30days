//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n=costs.length; int k=costs[0].length; int dp[][]=new int[n][k]; int ans=Integer.MAX_VALUE;
		if(n>1&&k==1)return -1;
	    for(int i=0;i<n;i++){
	        if(i==0)
	            for(int j=0;j<k;j++)dp[0][j]=costs[0][j];
	        else{
    	        int Fmin=Integer.MAX_VALUE; int Smin=Fmin; int fIdx=-1; int sIdx=-1;
    	        for(int j=0;j<k;j++){
    	            if(dp[i-1][j]<Fmin){
    	                Smin=Fmin;
    	                sIdx=fIdx;
    	                fIdx=j;
    	                Fmin=dp[i-1][j];
    	            }
    	            else if(dp[i-1][j]<Smin){
    	                Smin=dp[i-1][j];
    	                sIdx=fIdx;
    	            }
    	        }
    	        for(int j=0;j<k;j++){
    	            if(fIdx!=j)dp[i][j]=Fmin+costs[i][j];
    	            else dp[i][j]=Smin+costs[i][j];
    	        }
	        }
	        if(i==n-1)
	            for(int j=0;j<k;j++)ans=Math.min(ans,dp[i][j]);
	    }
	    return ans;
	}
}