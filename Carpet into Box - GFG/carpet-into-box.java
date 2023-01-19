//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int max=Math.max(C,D);
        int min=Math.min(C,D);
        int fMax=Math.max(A,B);
        int sMax=Math.min(A,B);
        int count=0;
        if((fMax<=max&&sMax<=min))
        return 0;
        else if(fMax<=max){
            while(sMax>min){
                count++;
                sMax/=2;
            }
        }
        else if(sMax<=min){
            while(fMax>max){
                count++;
                fMax/=2;
            }
        }
        else{
            return 1+carpetBox(fMax/2,sMax,C,D);
        }
        return count;

    }
   
}
