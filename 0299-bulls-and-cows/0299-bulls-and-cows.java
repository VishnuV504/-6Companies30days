class Solution {
    public String getHint(String secret, String guess) {
        int count=0; int n=secret.length();int freq[]=new int[10];
        int i=0;String ans="";
        while(i<n){
            if(secret.charAt(i)==guess.charAt(i))
                count++;
            else
                freq[guess.charAt(i)-48]++;
            i++;
        }
        i=0;ans+=count;
        ans+="A"; count=0;
        while(i<n){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(freq[secret.charAt(i)-48]>0){
                    count++;
                    freq[secret.charAt(i)-48]--;
                }
            }
            i++;
        }
        ans+=count;
        ans+="B";
        return ans;
    }
}