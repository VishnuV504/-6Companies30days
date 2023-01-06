class Solution {
    public String longestPrefix(String s) {
        int n=s.length(); int i=1; int j=0;
        int pre[]=new int[n];
        while(i<n){
            if(s.charAt(i)!=s.charAt(j)){
                i++;
            }
            else{
                while(i<n&&s.charAt(i)==s.charAt(j)){
                    pre[i]=j+1;
                    i++;
                    j++;
                }
                while(i<n&&s.charAt(i)!=s.charAt(j)&&j!=0){
                    j=pre[j-1];
                }
            }
        }
        return s.substring(0,pre[n-1]);
    }
}