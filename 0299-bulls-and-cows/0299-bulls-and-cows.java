class Solution {
    public String getHint(String secret, String guess) {
        int count=0; int n=secret.length();HashMap<Character,Integer>hs=new HashMap<>();
        int i=0;String ans="";
        while(i<n){
            if(secret.charAt(i)==guess.charAt(i))
                count++;
            else{
                if(hs.containsKey(guess.charAt(i)))
                    hs.put(guess.charAt(i),hs.get(guess.charAt(i))+1);
                else
                    hs.put(guess.charAt(i),1);
            }
            i++;
        }
        i=0;ans+=count;
        ans+="A"; count=0;
        while(i<n){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(hs.containsKey(secret.charAt(i))){
                    count++;
                    hs.put(secret.charAt(i),hs.get(secret.charAt(i))-1);
                    if(hs.get(secret.charAt(i))==0)hs.remove(secret.charAt(i));
                }
            }
            i++;
        }
        ans+=count;
        ans+="B";
        return ans;
    }
}