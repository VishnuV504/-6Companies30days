class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>(); int m=s.length(); int n=p.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++)freq[p.charAt(i)-'a']++;
        int i=0; int j=0;
        if(n>m)return ans;
        while(i-j+1<n){
            freq[s.charAt(i)-'a']--;
            i++;
        }
        while(i<m){
            freq[s.charAt(i)-'a']--; boolean flag=true;
            for(int k=0;k<26;k++){
                if(freq[k]!=0){
                    flag=false;
                    break;
                }
            }
            if(flag)ans.add(i-n+1);
            freq[s.charAt(i-n+1)-'a']++;
            i++;
        }
        return ans;
    }
}