class Pair{
    int node;
    int steps;
    int cost;
    Pair(int node,int steps,int cost){
        this.node=node;
        this.steps=steps;
        this.cost=cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        List<List<Pair>>g=new ArrayList<List<Pair>>();
        int ans[]=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<n;i++)g.add(new ArrayList<Pair>());
        for(int i=0;i<flights.length;i++){
            g.get(flights[i][0]).add(new Pair(flights[i][1],0,flights[i][2]));
        }
        Queue<Pair>q=new LinkedList<>(); int min=Integer.MAX_VALUE;
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            int node=q.peek().node;
            int steps=q.peek().steps;
            int cost=q.peek().cost;
            if(steps<=k&&node==dst)
                min=Math.min(min,cost);
            q.remove();
            if(steps<k){
                for(int i=0;i<g.get(node).size();i++){
                    int curr=g.get(node).get(i).node;
                    if((cost+g.get(node).get(i).cost)<ans[curr]){
                        q.add(new Pair(curr,steps+1,cost+g.get(node).get(i).cost));
                        ans[curr]=cost+g.get(node).get(i).cost;
                    }
                }
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}