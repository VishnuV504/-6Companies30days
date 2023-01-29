//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int a;
            a = Integer.parseInt(br.readLine());
            
            
            int b;
            b = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.solve(a, b);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int solve(int a, int b) {
        // code here
        int count=0; int common=0;
        if(a==b)return 0;
        for(int i=0;i<32;i++){
            int bit1=((a>>i)&1);
            int bit2=((b>>i)&1);
            if(bit1==1&&bit2==1)continue;
            if(bit1==1)count++;
            if(bit2==1)common++;
        }
        if(count>0&&common>0)return 2;
        return 1;
    }
}
        
