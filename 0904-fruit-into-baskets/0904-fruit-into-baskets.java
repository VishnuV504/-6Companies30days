class Solution {
    public int totalFruit(int[] fruits) {
        int maxLen=0; int n=fruits.length; int i=0; int j=0; int fir=-1; int sec=-1;
        while(i<n){
            if(fir!=-1&&sec!=-1&&fruits[i]!=fruits[fir]&&fruits[i]!=fruits[sec]){
                j=Math.min(fir+1,sec+1);
                if(j-1==fir)fir=-1;
                else sec=-1;
            }
            if(fir==-1||fruits[i]==fruits[fir])
                fir=i;
            else 
                sec=i;
            maxLen=Math.max(maxLen,i-j+1);
            i++;
        }
        return maxLen;
    }
}