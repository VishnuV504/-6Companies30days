class Solution {
    int dir[][]={{0,1},{1,0},{0,-1},{-1,0}}; int count=0;
    public int closedIsland(int[][] grid) {
        int m=grid.length; int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||i==m-1)&&(grid[i][j]==0))
                    solve(i,j,grid);
                else if((j==0||j==n-1)&&grid[i][j]==0)
                    solve(i,j,grid);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                    solve(i,j,grid);
                }
            }
        }
        return count;
    }
    public void solve(int i,int j,int grid[][]){
        grid[i][j]=1;
        for(int k=0;k<4;k++){
            int row=i+dir[k][0]; int col=j+dir[k][1];
            if(row>=0&&row<grid.length&&col>=0&&col<grid[0].length&&grid[row][col]==0)
                solve(row,col,grid);
        }
    }
}