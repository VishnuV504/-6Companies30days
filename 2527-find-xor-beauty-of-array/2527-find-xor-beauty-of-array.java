class Solution {
    public int xorBeauty(int[] nums) {
        int xor=0; int n=nums.length;
        for(int i=0;i<n;i++)
            xor^=nums[i];
        return xor;
    }
}