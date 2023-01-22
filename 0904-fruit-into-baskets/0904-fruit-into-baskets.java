class Solution {
    public int totalFruit(int[] fruits) {
        int i=0; int j=0; int n=fruits.length; HashMap<Integer,Integer>hs=new HashMap<>();
        int max=0;
        while(i<n){
            while((!hs.containsKey(fruits[i]))&&hs.size()==2){
                if(hs.get(fruits[j])==1)
                    hs.remove(fruits[j]);
                else
                    hs.put(fruits[j],hs.get(fruits[j])-1);
                j++;
            }
            if(hs.containsKey(fruits[i]))
                hs.put(fruits[i],hs.get(fruits[i])+1);
            else
                hs.put(fruits[i],1);
            max=Math.max(max,i-j+1);
            i++;
        }
        return max;
        
    }
}