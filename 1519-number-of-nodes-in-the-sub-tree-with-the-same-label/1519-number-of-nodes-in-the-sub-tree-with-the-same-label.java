class Node{
    int val;
    int freq[];
    ArrayList<Node>child;
    Node(int val){
        this.val=val;
        this.child=new ArrayList<>();
        this.freq=new int[26];
    }
    void Add(Node temp){
        child.add(temp);
    }
}
class Solution {
    ArrayList<ArrayList<Integer>>g=new ArrayList<ArrayList<Integer>>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer,Integer>hs=new HashMap<>();
        for(int i=0;i<n;i++)
            g.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            if(edges[i][0]>edges[i][1]){
                int temp=edges[i][0];
                edges[i][0]=edges[i][1];
                edges[i][1]=temp;
            }
            if(edges[i][0]==0||hs.containsKey(edges[i][0])){
                g.get(edges[i][0]).add(edges[i][1]);
                hs.put(edges[i][1],1);
            }
            else{
                g.get(edges[i][1]).add(edges[i][0]);
                hs.put(edges[i][0],1);
            }
        }
        int ans[]=new int[n];
        Node root=new Node(0);Node dummy=root;
        build(root);
        solve(dummy,labels,ans);
        return ans;
        
    }
    public void build(Node root){
        for(int i=0;i<g.get(root.val).size();i++){
            Node temp=new Node(g.get(root.val).get(i));
            root.child.add(temp);
            build(temp);
        }
    }
    public void solve(Node dummy,String s,int ans[]){
        if(dummy==null)return ;
        int pre[]=new int[26];
        dummy.freq[s.charAt(dummy.val)-'a']++;
            for(int i=0;i<dummy.child.size();i++){
                Node num=dummy.child.get(i);
                solve(num,s,ans);
                for(int j=0;j<26;j++){
                    pre[j]+=num.freq[j];
                }
            }
            for(int i=0;i<26;i++){
                dummy.freq[i]+=pre[i];
            }
        ans[dummy.val]=dummy.freq[s.charAt(dummy.val)-'a'];
    }
}