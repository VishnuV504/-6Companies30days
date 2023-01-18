class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSoFar=nums[0]; int minSoFar=nums[0]; int total=nums[0]; int n=nums.length; int totalMax=nums[0];
        int totalMin=nums[0];
        for(int i=1;i<n;i++){
            maxSoFar=Math.max(maxSoFar+nums[i],nums[i]);
            totalMax=Math.max(totalMax,maxSoFar);
            total+=nums[i];
            minSoFar=Math.min(minSoFar+nums[i],nums[i]);
            totalMin=Math.min(totalMin,minSoFar);
        }
        if(totalMin==total)
            return totalMax;
        return Math.max(totalMax,total-totalMin);
    }
}