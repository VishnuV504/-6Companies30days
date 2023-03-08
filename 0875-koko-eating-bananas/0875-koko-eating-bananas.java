class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1; int high=Integer.MAX_VALUE; int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public boolean solve(int arr[],int h,int k){
        int n=arr.length; int i=0; long count=0;
        while(i<n){
            count+=arr[i]/k;
            if(arr[i]%k!=0)count++;
            if(count>h)return false;
            i++;
        }
        return true;
    }
}