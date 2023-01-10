class Solution {
    int max=0;int temp=0;
    public int maximumGood(int[][] statements) {
        solve(0,statements,0);
        return max;
    }
    public void solve(int curr,int arr[][],int bitMask){
        if(curr>=arr.length){
            temp=bitMask; boolean visited[]=new boolean[arr.length];boolean flag=true;
            int ans[]=new int[arr.length];Arrays.fill(ans,2);
            for(int i=0;i<arr.length;i++){
                if(((bitMask>>i)&1)==1){
                    if(dfs(i,visited,arr,ans)==false){
                        flag=false;
                        break;
                    }
                }
            }
            flag=flag&&check(arr,temp,ans);
            if(flag){
                int count=0; 
                while(temp!=0){
                    temp&=(temp-1);
                    count++;
                }
                max=Math.max(max,count);
            }
            temp=0;
            return;
        }
        solve(curr+1,arr,bitMask);
        bitMask|=(1<<curr);
        solve(curr+1,arr,bitMask);
        bitMask^=(1<<curr);
        return ;
    }
    public boolean check(int arr[][],int bitMask,int ans[]){
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            if(((bitMask>>i)&1)==1){
                ans[i]=1;
                for(int j=0;j<arr.length;j++){
                    if(arr[i][j]==2)continue;
                    if(ans[j]!=2&&arr[i][j]!=ans[j]){
                        flag=false;
                        break;
                    }
                    ans[j]=arr[i][j];
                }
            }
            if(flag==false)
                break;
        }
        return flag;
    }
    public boolean dfs(int curr,boolean visited[],int arr[][],int ans[]){
        if(visited[curr])
            return true;
        visited[curr]=true;ans[curr]=1;
        for(int i=0;i<arr.length;i++){
            if(arr[curr][i]==2)continue;
            if(ans[i]!=2&&arr[curr][i]!=ans[i])return false;
            if(arr[curr][i]==1){
                temp|=(1<<i);
                dfs(i,visited,arr,ans);
            }
            else if(arr[curr][i]==0)
                ans[i]=0;
        }
        return true;
    }
}