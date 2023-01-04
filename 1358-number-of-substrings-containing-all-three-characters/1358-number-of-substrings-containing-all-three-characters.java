class Solution {
    public int numberOfSubstrings(String s) {
        long n=s.length();int j=0; long count=0;
        int countA,countB,countC;countA=countB=countC=0;
        for(int i=0;i<n;i++){
            while((s.charAt(i)=='a'&&countB>=1&&countC>=1)||(s.charAt(i)=='b'&&countA>=1&&countC>=1)||(s.charAt(i)=='c'&&countA>=1&&countB>=1)){
                if(s.charAt(j)=='a')countA--;
                else if(s.charAt(j)=='b')countB--;
                else countC--;
                j++;
            }
            if(s.charAt(i)=='a')countA++;
            else if(s.charAt(i)=='b')countB++;
            else countC++;
            count+=i-j+1;
        }
        return (int)(n*(n+1)/2-count);
    }
}