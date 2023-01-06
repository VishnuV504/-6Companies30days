class Solution {
    long mod=1000_000_000+7;
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer>hs=new HashMap<>(); long ans=0; int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i]-reverse(nums[i]);
            if(hs.containsKey(num))
                hs.put(num,hs.get(num)+1);
            else
                hs.put(num,1);
        }
        for(int i=0;i<n;i++){
            int num=nums[i]-reverse(nums[i]);
            hs.put(num,hs.get(num)-1);
            if(hs.get(num)==0)hs.remove(num);
            if(hs.containsKey(num))
                ans=(ans+(hs.get(num))%mod)%mod;
        }
        return (int)ans;
    }
    public int reverse(int num){
        int ans=0;
        while(num>0){
            ans*=10;
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
}