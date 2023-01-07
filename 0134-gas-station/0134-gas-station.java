class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length; int total=0;
        int ans=0; int gasReq=0;
        for(int i=0;i<n;i++){
            gasReq+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(gasReq<0){
                gasReq=0;
                ans=i+1;
            }
        }
        if(total<0)return -1;
        return ans;
    }
}