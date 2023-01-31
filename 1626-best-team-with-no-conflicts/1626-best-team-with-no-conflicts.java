class Solution {
    Integer dp[][]=new Integer[1001][1002];
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=ages[i];
            arr[i][1]=scores[i];
        }
        Arrays.sort(arr,(a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);
        return solve(0,arr,-1);
    }
    public int solve(int curr,int arr[][],int prevIdx){
        if(curr>=arr.length)return 0;
        if(dp[curr][prevIdx+1]!=null)return dp[curr][prevIdx+1];
        if(prevIdx==-1||arr[curr][1]>=arr[prevIdx][1])
            return dp[curr][prevIdx+1]=Math.max(arr[curr][1]+solve(curr+1,arr,curr),solve(curr+1,arr,prevIdx));
        return dp[curr][prevIdx+1]=solve(curr+1,arr,prevIdx);
    }
}