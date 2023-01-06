class Solution {
    public String longestPrefix(String s) {
        int n=s.length(); int i=1; int j=0;
        int pre[]=new int[n];
        while(i<n){
            if(s.charAt(i)!=s.charAt(j)){
                while(j>0&&s.charAt(i)!=s.charAt(j))
                    j=pre[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                pre[i]=j+1;
                j++;
            }
            i++;
        }
        return s.substring(0,pre[n-1]);
    }
}