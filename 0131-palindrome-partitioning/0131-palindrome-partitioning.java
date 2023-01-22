class Solution {
    List<List<String>>ans=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        int n=s.length(); boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            int k=0;
            for(int j=i;j<n;j++){
                if(k==j)
                    dp[k][j]=true;
                else if(j-k==1)
                    dp[k][j]=(s.charAt(k)==s.charAt(j));
                else
                    dp[k][j]=dp[k+1][j-1]&&(s.charAt(k)==s.charAt(j));
                k++;
            }
        }
        solve(0,-1,s,new StringBuilder(),new ArrayList<String>(),dp);
        return ans;
    }
    public void solve(int curr,int last,String s,StringBuilder sb,ArrayList<String>li,boolean dp[][]){
        if(curr==s.length()){
            if(last==s.length()-1)
                ans.add(new ArrayList<>(li));
            return;
        }
        if(dp[last+1][curr]){
            li.add(s.substring(last+1,curr+1));
            solve(curr+1,curr,s,sb,li,dp);
            li.remove(li.size()-1);
        }
        solve(curr+1,last,s,sb,li,dp);
    }
}