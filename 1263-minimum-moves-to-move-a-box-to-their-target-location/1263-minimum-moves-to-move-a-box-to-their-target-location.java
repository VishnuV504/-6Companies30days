class Pair{
    int row;
    int col;
    int humanRow;
    int humanCol;
    Pair(int row,int col,int humanRow,int humanCol){
        this.row=row;
        this.col=col;
        this.humanRow=humanRow;
        this.humanCol=humanCol;
    }
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
    public int minPushBox(char[][] grid) {
        int m=grid.length; int n=grid[0].length;int boxRow=-1; int boxCol=-1;
        boolean visited[][][]=new boolean[m][n][4]; int row=-1; int col=-1;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='B'){
                    boxRow=i;boxCol=j;
                }
                if(grid[i][j]=='S'){
                    row=i;
                    col=j;
                }
            }
        }
        q.add(new Pair(boxRow,boxCol,row,col));
        int moves=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                row=q.peek().row;int humanRow=q.peek().humanRow;
                col=q.peek().col;int humanCol=q.peek().humanCol;
                q.remove();
                for(int i=0;i<4;i++){
                    int currRow=row+dir[i][0];
                    int currCol=col+dir[i][1];
                    if(currRow<m&&currCol<n&&currRow>=0&&currCol>=0&&grid[currRow][currCol]!='#'&&canGo(grid,i,humanRow,humanCol,row,col)){
                        if(visited[currRow][currCol][i]==false){
                            if(grid[currRow][currCol]=='T')return moves;
                            int targetRow=row; int targetCol=col;
                            if(i==0)
                                targetCol-=1;
                            else if(i==1)
                                targetRow-=1;
                            else if(i==2)
                                targetCol+=1;
                            else
                                targetRow+=1;
                            q.add(new Pair(currRow,currCol,targetRow,targetCol));
                            visited[currRow][currCol][i]=true;
                        }
                    }
                }
                size--;
            }
            moves++;
        }
        return -1;
    }
    public boolean canGo(char grid[][],int idx,int humanRow,int humanCol,int boxRow,int boxCol){
        Queue<Pair>q=new LinkedList<>(); int m=grid.length; int n=grid[0].length;
        int targetRow=boxRow; int targetCol=boxCol; 
        if(idx==0)
            targetCol-=1;
        else if(idx==1)
            targetRow-=1;
        else if(idx==2)
            targetCol+=1;
        else
            targetRow+=1;
        if(targetRow==humanRow&&targetCol==humanCol)return true;
        q.add(new Pair(humanRow,humanCol));
        boolean visited[][]=new boolean[m][n];
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int currRow=row+dir[i][0];
                int currCol=col+dir[i][1];
                if(row==boxRow&&col==boxCol)continue;
                if(currRow<m&&currCol<n&&currRow>=0&&currCol>=0&&grid[currRow][currCol]!='#'&&visited[currRow][currCol]==false){
                    if(currRow==targetRow&&currCol==targetCol)return true;
                    q.add(new Pair(currRow,currCol));
                    visited[currRow][currCol]=true;
                }
            }
        }
        return false;
    }
}