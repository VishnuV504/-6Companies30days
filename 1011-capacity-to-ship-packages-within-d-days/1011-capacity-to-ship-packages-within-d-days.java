class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0; int high=Integer.MAX_VALUE; int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public boolean solve(int arr[],int k,int c){
        int i=0; int n=arr.length; int w=0;
        while(i<n){
            while(i<n&&arr[i]+w<=c){
                w+=arr[i];
                i++;
            }
            k--;
            if(k==0)break;
            w=0;
        }
        return i==n;
    }
}