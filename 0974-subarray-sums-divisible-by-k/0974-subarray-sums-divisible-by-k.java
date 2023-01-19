class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0; int n=nums.length; HashMap<Integer,Integer>hs=new HashMap<>();
        hs.put(0,1); int sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+((nums[i]%k+k)%k))%k;
            if(hs.containsKey(sum)){
                int temp=hs.get(sum);
                count+=temp;
                hs.put(sum,temp+1);
            }
            else 
                hs.put(sum,1);
        }
        return count;
        
    }
}