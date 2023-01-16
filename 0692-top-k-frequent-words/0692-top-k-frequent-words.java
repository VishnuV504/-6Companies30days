class Pair{
    int val;
    String s;
    Pair(int val,String s){
        this.val=val;
        this.s=s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>hs=new HashMap<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->(a.val==b.val)?(b.s).compareTo(a.s):a.val-b.val); List<String>ans=new ArrayList<>(); int n=words.length;
        for(int i=0;i<n;i++){
            if(hs.containsKey(words[i]))
                hs.put(words[i],hs.get(words[i])+1);
            else
                hs.put(words[i],1);
        }
        for(String Key:hs.keySet()){
            if(pq.size()<k)pq.add(new Pair(hs.get(Key),Key));
            else if((hs.get(Key)==pq.peek().val)&&(Key.compareTo(pq.peek().s)<0)){
                pq.poll();
                pq.add(new Pair(hs.get(Key),Key));
            }
            else if(hs.get(Key)>pq.peek().val){
                pq.poll();
                pq.add(new Pair(hs.get(Key),Key));
            }
            
        }
        while(!pq.isEmpty())
            ans.add(pq.poll().s);
        Collections.reverse(ans);
        return ans;
    }
}