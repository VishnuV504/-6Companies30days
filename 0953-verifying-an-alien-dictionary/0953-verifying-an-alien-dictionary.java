class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer>hs=new HashMap<>(); int n=order.length();
        for(int i=0;i<n;i++)
            hs.put(order.charAt(i),i);
        String s=words[0];
        for(int i=1;i<words.length;i++){
            String word=words[i];
            int j=0; int k=0; boolean flag=true;
            while(j<word.length()&&k<s.length()){
                if(hs.get(word.charAt(j))<hs.get(s.charAt(k)))return false;
                if(word.charAt(j)==s.charAt(k)){
                    j++;
                    k++;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag&&k<s.length())return false;
            s=word;
        }
        return true;
    }
}