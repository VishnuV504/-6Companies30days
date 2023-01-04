class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        long num=numsDivide[0]; int n=numsDivide.length;
        TreeMap<Integer,Integer>hs=new TreeMap<>();
        for(int i=1;i<n;i++)
            num=gcd(num,numsDivide[i]);
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(nums[i]))
                hs.put(nums[i],hs.get(nums[i])+1);
            else
                hs.put(nums[i],1);
        }
        int count=0;
        for(Integer key:hs.keySet()){
            if(num%key==0)return count;
            count+=hs.get(key);
        }
        return -1;
    }
    public  long  gcd(long a,long b){
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}