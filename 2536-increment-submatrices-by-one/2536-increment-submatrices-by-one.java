class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int pre[][]=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int row1=queries[i][0]; int col1=queries[i][1];int row2=queries[i][2]; int col2=queries[i][3];
                pre[row1][col1]+=1;
                if(col2+1<n){
                    pre[row1][col2+1]-=1;
                }
                if(row2+1<n&&col2+1<n)
                    pre[row2+1][col2+1]+=1;  
                if(row2+1<n)
                pre[row2+1][col1]-=1;
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=pre[i][j];
                if(i!=0){
                    sum+=pre[i-1][j];
                    if(j>0)
                        sum-=pre[i-1][j-1];
                }
                pre[i][j]=sum;
            }
        }
        return pre;        
    }
}