class Solution {
    public int numberOfSubstrings(String s) {
        long n=s.length();int j=0; long count=0;
        HashMap<Character,Integer>hs=new HashMap<>();
        for(int i=0;i<n;i++){
            while(!hs.containsKey(s.charAt(i))&&hs.size()==2){
                if(hs.get(s.charAt(j))==1)
                    hs.remove(s.charAt(j));
                else
                    hs.put(s.charAt(j),hs.get(s.charAt(j))-1);
                j++;
            }
            if(hs.containsKey(s.charAt(i)))
                hs.put(s.charAt(i),hs.get(s.charAt(i))+1);
            else
                hs.put(s.charAt(i),1);
            count+=i-j+1;
        }
        return (int)(n*(n+1)/2-count);
    }
}