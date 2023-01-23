class Trie{
    Trie Node[]=new Trie[201];
    int count;
    Trie(int count){
        this.count=count;
    }
    int getCount(Trie Node){
        return Node.count;
    }
    boolean contains(Trie Node,int num){
        if(Node.Node[num]==null)return false;
        return true;
    }
    void insert(Trie Node,int num,Trie NodeToBeInserted){
        Node.Node[num]=NodeToBeInserted;
    }
    Trie go(Trie Node,int num){
        return Node.Node[num];
    }
    
}
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Trie root=new Trie(0); Trie dummy=new Trie(-1);
        dummy=root; int n=nums.length; int count=0;
        for(int i=0;i<n;i++){
            root=dummy; int ans=0;
            for(int j=i;j<n;j++){
                boolean flag=false;
                if(nums[j]%p==0)ans++;
                if(!root.contains(root,nums[j])){
                    root.insert(root,nums[j],new Trie(ans));
                    flag=true;
                }
                root=root.go(root,nums[j]);
                if(root.getCount(root)<=k&&flag)count++;
                
            }
        }
        return count;
    }
}