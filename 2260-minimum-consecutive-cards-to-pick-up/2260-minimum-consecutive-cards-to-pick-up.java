class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer>hs=new HashMap<>(); int min=Integer.MAX_VALUE; boolean flag=false;
        int n=cards.length;
        for(int i=0;i<n;i++){
            if(hs.containsKey(cards[i])){
                flag=true;
                min=Math.min(min,i-hs.get(cards[i])+1);
            }
            hs.put(cards[i],i);
        }
        if(flag==false)return -1;
        return min;
    }
}