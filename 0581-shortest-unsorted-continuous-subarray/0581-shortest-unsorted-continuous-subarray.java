class Pair{
    int num;
    int idx;
    Pair(int num,int idx){
        this.num=num;
        this.idx=idx;
    }
}
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->(a.num==b.num)?a.idx-b.idx:a.num-b.num);
        for(int i=0;i<n;i++)
            pq.add(new Pair(nums[i],i));
        int low=Integer.MAX_VALUE; int max=Integer.MIN_VALUE; int count=0;
        while(!pq.isEmpty()){
            if(pq.peek().idx!=count){
                low=Math.min(count,low);
                max=Math.max(count,max);
            }
            pq.poll();count++;
        }
        if(low==Integer.MAX_VALUE)return 0;
        return max-low+1;
    }
}