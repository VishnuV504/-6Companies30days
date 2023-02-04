class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26]; int m=s1.length(); int n=s2.length();
        if(m>n)return false;
        for(int i=0;i<m;i++)freq[s1.charAt(i)-'a']++;
        int i=0; int j=0;
        while(i-j+1<m){
            freq[s2.charAt(i)-'a']--;
            i++;
        }
        while(i<n){
            freq[s2.charAt(i)-'a']--;
            boolean flag=true;
            for(int k=0;k<26;k++){
                if(freq[k]!=0){
                    flag=false;
                    break;
                }
            }
            if(flag)return true;
            freq[s2.charAt(i-m+1)-'a']++;
            i++;
        }
        return false;
    }
}