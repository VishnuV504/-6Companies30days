class Solution {
    public int findKthPositive(int[] arr, int k) {
        int prev=0; int n=arr.length; int i=0;
        while(i<n){
            if(k>arr[i]-prev-1)k-=arr[i]-prev-1;
            else return prev+k;
            prev=arr[i];
            i++;
        }
        return prev+k;
    }
}