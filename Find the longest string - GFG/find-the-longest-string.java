//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Trie{
    boolean flag;
    Trie arr[]=new Trie[26];
    boolean contains(Trie node,char c){
        if(node.arr[c-'a']==null)return false;
        return true;
    }
    void toBeConnected(Trie Node,char c,Trie a){
        Node.arr[c-'a']=a;
    }
    Trie go(Trie Node,char c){
        return Node.arr[c-'a'];
    }
    void setFlag(Trie Node){
        Node.flag=true;
    }
    boolean getFlag(Trie Node){
        return Node.flag;
    }
}
class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        return insert(arr);
    }
    public static String insert(String arr[]){
        int n=arr.length; Trie root=new Trie();
        Trie dummy=root;
        for(int i=0;i<n;i++){
            String word=arr[i];root=dummy;
            for(int j=0;j<word.length();j++){
                if(!root.contains(root,word.charAt(j))){
                    root.toBeConnected(root,word.charAt(j),new Trie());
                }
                root=root.go(root,word.charAt(j));
            }
            root.setFlag(root);
        }
        
        int maxLen=0; String ans="";Arrays.sort(arr);
        for(int i=0;i<n;i++){
            String word=arr[i];boolean flag=true;root=dummy;
            for(int j=0;j<word.length();j++){
                root=root.go(root,word.charAt(j));
                if(root.getFlag(root)==false){
                    flag=false;
                    break;
                }
            }
            if(flag&&word.length()>maxLen){
                maxLen=word.length();
                ans=word;
            }
        }
        return ans;

    }
}
        
