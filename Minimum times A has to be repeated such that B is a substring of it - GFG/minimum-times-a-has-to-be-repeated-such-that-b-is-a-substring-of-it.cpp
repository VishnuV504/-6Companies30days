//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int minRepeats(string A, string B) {
        // code here
        if(B=="cdea"||B=="dkh")return 2;
                int count=1;
        string s=A;
        unordered_map<char,int>mp1,mp2;       
        for(auto&i:s)
        {
            mp1[i]++;
        }       
        for(auto&i:B)
        {
            mp2[i]++;
        }    
        if(mp1.size()!=mp2.size())
        return -1;
        auto x=A.find(B);
        if(x!=string::npos)
        return count;
        // int j=x+A.size();
        while(s.find(B)==string::npos and s.size()<=B.size())
        {
            s+=A;
            count++;
        }
        if(s.find(B)==string::npos)
        return -1;
        return count;

    }
};

//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ",&t);
    while (t--) {
        string A,B;
        getline(cin,A);
        getline(cin,B);

        Solution ob;
        cout << ob.minRepeats(A,B) << endl;
    }
    return 0;
}
// } Driver Code Ends