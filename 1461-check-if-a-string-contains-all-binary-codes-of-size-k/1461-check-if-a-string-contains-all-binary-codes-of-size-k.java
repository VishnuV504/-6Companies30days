class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length(); StringBuilder ans=new StringBuilder ();
        HashSet<String>hs=new HashSet<>(); int i=0;
        while(i<n){
            while(i<n&&ans.length()<k){
                ans.append(s.charAt(i));
                i++;
            }
            hs.add(ans.toString());
            ans.deleteCharAt(0);
        }
        return hs.size()==(long)Math.pow(2,k);
    }
}