class Solution {
    HashMap<Integer,Integer>hs=new HashMap<>(); int min=Integer.MAX_VALUE; int idx=-1;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        dfs(node1,edges,0,new HashSet<Integer>());
        dfs(node2,edges,0,new HashSet<Integer>());
        return idx;
    }
    public void dfs(int curr,int edges[],int dis,HashSet<Integer>vis){
        if(vis.contains(curr))return;
        vis.add(curr);
        if(hs.containsKey(curr)){
            int num=Math.max(dis,hs.get(curr));
            if(num<min){
                min=num;
                idx=curr;
            }
            else if(num==min&&curr<idx)
                idx=curr;
        }
        else
        hs.put(curr,dis);
        if(edges[curr]!=-1)
        dfs(edges[curr],edges,dis+1,vis);
    }
}