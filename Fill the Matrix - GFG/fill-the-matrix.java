//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Pair{
        int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int rounds=0;
		Queue<Pair>q=new LinkedList<>();
		q.add(new Pair(x-1,y-1));
		int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
		boolean visited[][]=new boolean[N][M];
		while(!q.isEmpty()){
		    int size=q.size();
		    while(size!=0){
		        int currX=q.peek().x;
		        int currY=q.peek().y;
		        q.remove();
		        for(int i=0;i<4;i++){
		            int X=currX+dir[i][0]; int Y=currY+dir[i][1];
		            if(X>=0&&X<N&&Y>=0&&Y<M&&visited[X][Y]==false){
		                visited[X][Y]=true;
		                q.add(new Pair(X,Y));
		            }
		        }
		        size--;
		    }
		    rounds++;
		}
		return rounds-1;
		
	}
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends