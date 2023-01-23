class Pair{
    int edge;
    int cost;
    Pair(int edge,int cost){
        this.edge=edge;
        this.cost=cost;
    }
}
class Solution {
    ArrayList<ArrayList<Pair>>g=new ArrayList<ArrayList<Pair>>();
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans[]=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;
        for(int i=0;i<=n;i++)
            g.add(new ArrayList<Pair>());
        for(int i=0;i<times.length;i++)
            g.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            int cost=q.peek().cost;
            int node=q.peek().edge;
            q.remove();
            for(int i=0;i<g.get(node).size();i++){
                int currNode=g.get(node).get(i).edge;
                int currCost=cost+g.get(node).get(i).cost;
                if(currCost<ans[currNode]){
                    ans[currNode]=currCost;
                    q.add(new Pair(currNode,currCost));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(max,ans[i]);
        }
        return max;
    }
}