//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int count=0;
        while(b!=0){
            b&=(b-1);
            count++;
        }
        int num=0;
        for(int i=31;i>=0;i--){
            if(((a>>i)&1)==1){
                num|=(1<<i);
                count--;
            }
            if(count<=0)return num;
        }
        int i=0;
        while(count>0){
            if(((num>>i)&1)==0){
                num|=(1<<i);
                count--;
            }
            i++;
        }
        return num;
    }
}