class Solution {
    public int totalFruit(int[] fruits) {
        int i=0; int j=0; int n=fruits.length; HashMap<Integer,Integer>hs=new HashMap<>();
        int max=0; int fir=-1; int sec=-1;
        while(i<n){
            if(fir!=-1&&sec!=-1&&fruits[i]!=fruits[fir]&&fruits[i]!=fruits[sec]){
                j=Math.min(fir,sec);
                if(j==fir)
                    fir=-1;
                else
                    sec=-1;
                j++;
            }
            if(fir==-1)
                fir=i;
            else if(fruits[fir]!=fruits[i]&&sec==-1)
                sec=i;
            else if(fruits[i]==fruits[fir])
                fir=i;
            else
                sec=i;
            max=Math.max(max,i-j+1);
            i++;
        }
        return max;
        
    }
}