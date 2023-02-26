//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int  count=0;
        boolean visited[]=new boolean[V+1];
        for(int i=1;i<=V;i++){
            if(visited[i]==false){
                ArrayList<Integer>li=new ArrayList<>();
                dfs(i,adj,visited,li);
                boolean flag=true;
                for(int j=0;j<li.size();j++){
                    if(adj.get(li.get(j)).size()!=li.size()-1){
                        flag=false;
                        break;
                    }
                }
                if(flag)count++;
            }
        }
        return count;
    }
    public void dfs(int curr,ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer>li){
        visited[curr]=true;
        li.add(curr);
        for(int i=0;i<adj.get(curr).size();i++){
            int now=adj.get(curr).get(i);
            if(visited[now]==false)
            dfs(now,adj,visited,li);
        }
    }
}