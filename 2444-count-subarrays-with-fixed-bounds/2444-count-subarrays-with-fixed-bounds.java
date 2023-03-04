class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0; int i=0; int j=0; int n=nums.length; 
        Deque<Integer>min=new LinkedList<>(); Deque<Integer>max=new LinkedList<>(); 
        while(i<n){
            while(!min.isEmpty()&&nums[i]<=nums[min.peek()])min.poll();
            while(!max.isEmpty()&&nums[i]>=nums[max.peek()])max.poll();
            if(nums[i]<minK||nums[i]>maxK){
                j=i+1;
                min.clear(); max.clear();
            }
            else{
                min.add(i);
                max.add(i);
            }
            if((!min.isEmpty())&&(!max.isEmpty())&&nums[max.peek()]==maxK&&nums[min.peek()]==minK)
                ans+=Math.min(min.peek(),max.peek())-j+1;
            i++;
        }
        return ans;
    }
}