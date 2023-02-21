class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0; int high=nums.length-1; int n=nums.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==0){
                if(mid+1<n){
                    if(nums[mid]==nums[mid+1])
                        low=mid+1;
                    else
                        return nums[mid];
                }
                else
                    return nums[mid];
            }
            else if(mid==n-1){
                if(mid-1>=0){
                    if(nums[mid]==nums[mid-1])
                        high=mid-1;
                    else
                        return nums[mid];
                }
                else
                    return nums[mid];
            }
            else{
                if(nums[mid]!=nums[mid+1]){
                    if(nums[mid]!=nums[mid-1])
                        return nums[mid];
                    if(mid%2==0)high=mid-1;
                    else low=mid+1;
                }
                else{
                    if(mid%2==0)low=mid+1;
                    else high=mid-1;
                }
            }
        }
        return 0;
    }
}