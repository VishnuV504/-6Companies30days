//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int dp[][]=new int[N][3];
        for(int i=0;i<3;i++)dp[0][i]=colors[0][i];
        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==0)
                dp[i][j]=Math.min(dp[i-1][j+1],dp[i-1][j+2])+colors[i][j];
                else if(j==2)
                dp[i][j]=colors[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j-2]);
                else
                dp[i][j]=colors[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j+1]);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<3;i++)ans=Math.min(ans,dp[N-1][i]);
        return ans;
    }
}