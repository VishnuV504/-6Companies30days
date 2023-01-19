class Solution {
    public long countBadPairs(int[] nums) {
        long count=0; long n=nums.length;
        HashMap<Integer,Integer>hs=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hs.containsKey(nums[i]-i))
                hs.put(nums[i]-i,hs.get(nums[i]-i)+1);
            else
                hs.put(nums[i]-i,1);
        }
        for(int i=0;i<n;i++){
            int num=nums[i]-i;
            if(hs.get(num)==1)
                hs.remove(num);
            else{
                hs.put(num,hs.get(num)-1);
                count+=hs.get(num);
            }
        }
        n--;
        return n*(n+1)/2-count;
        
    }
}