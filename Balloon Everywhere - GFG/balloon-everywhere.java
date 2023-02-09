//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        int n=s.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++)freq[s.charAt(i)-'a']++;
        int min=Integer.MAX_VALUE;
        min=Math.min(min,freq[1]);
        min=Math.min(min,freq[0]);
        min=Math.min(min,freq[11]/2);
        min=Math.min(min,freq[14]/2);
        min=Math.min(min,freq[13]);
        if(min==Integer.MAX_VALUE)return 0;
        return min;
    }
}