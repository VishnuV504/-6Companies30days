class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=0; long high=Long.MAX_VALUE; long ans=-1; int n=time.length;
        for(int i=0;i<n;i++)
            high=Math.min(time[i],high);
        high*=totalTrips;
        while(low<=high){
            long mid=low+(high-low)/2l;
            if(solve(time,mid,totalTrips)){
                ans=mid;
                high=mid-1l;
            }
            else
                low=mid+1l;
        }
        return ans;
    }
    public boolean solve(int arr[],long k,int trips){
        long count=0; int n=arr.length;
        for(int i=0;i<n;i++){
            long num=arr[i];
            count+=k/num;
        }
        return count>=trips;
    }
}