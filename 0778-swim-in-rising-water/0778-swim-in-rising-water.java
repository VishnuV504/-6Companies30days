class Solution {
    public int swimInWater(int[][] grid) {
        Queue<Pair>q=new PriorityQueue<>((a,b)->a.prev-b.prev);
        int m=grid.length; int n=grid[0].length;
        int visited[][]=new int[m][n]; q.add(new Pair(0,0,grid[0][0]));
        for(int i=0;i<m;i++)Arrays.fill(visited[i],Integer.MAX_VALUE);
        visited[0][0]=grid[0][0];
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                int row=q.peek().row;
                int col=q.peek().col;
                int prev=q.peek().prev;
                q.remove();
                for(int i=0;i<4;i++){
                    int currRow=row+dir[i][0];
                    int currCol=col+dir[i][1];
                    if(currRow>=0&&currCol>=0&&currRow<m&&currCol<n){
                        int currPrev=Math.max(prev,grid[currRow][currCol]);
                        if(visited[currRow][currCol]>currPrev){
                            visited[currRow][currCol]=currPrev;
                            q.add(new Pair(currRow,currCol,currPrev));
                        }
                    }
                }
                size--;
            }
        }
        return visited[m-1][n-1];
    }
}
class Pair{
    int row;
    int col;
    int prev;
    Pair(int row,int col,int prev){
        this.row=row;
        this.col=col;
        this.prev=prev;
    }
}