class Solution {
    public int maxProfit(int[] prices) {
        int max=0; int low=100000; int n=prices.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,prices[i]-low);
            low=Math.min(low,prices[i]);
        }
        return max;
    }
}