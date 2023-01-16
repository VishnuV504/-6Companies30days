class Solution {
    HashMap<Character,Integer>hs=new HashMap<>();
    public String customSortString(String order, String s) {
        StringBuilder dummy=new StringBuilder();
        int n=order.length();PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->
            getPos(a)-getPos(b));
        for(int i=0;i<n;i++)hs.put(order.charAt(i),i);
        for(int i=0;i<s.length();i++){
            if(hs.containsKey(s.charAt(i)))
            pq.add(s.charAt(i));
            else
                dummy.append(s.charAt(i));
        }
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty())
            ans.append(pq.poll());
        ans.append(dummy);
        return ans.toString();
        
    }
    public int getPos(char c){
        return hs.get(c);
    }
}