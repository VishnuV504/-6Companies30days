class Solution {
    int freq[]=new int[128];
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n=queries.length;int m=pattern.length();List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            char c=pattern.charAt(i);
            if(c>=65&&c<=90)
                freq[c]++;
        }
        for(int i=0;i<n;i++){
            String word=queries[i];
            if(solve(word,pattern)&&check(word))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
    public boolean check(String s){
        int n=s.length();int freq2[]=new int[128];
        for(int j=0;j<n;j++){
            char c=s.charAt(j);
            if(c>=65&&c<=90)
                freq2[c]++;
        }
        for(int i=0;i<128;i++)
            if(freq[i]!=freq2[i])return false;
        return true;
    }
    public boolean solve(String s,String t){
        int i=0;int j=0; int m=s.length(); int n=t.length();
        while(i<m&&j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;j++;
            }
            else
                i++;
        }
        return j==n;
    }
}