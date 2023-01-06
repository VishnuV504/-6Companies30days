class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs); int n=costs.length; int i=0;int count=0;
        while(i<n){
            if(costs[i]<=coins){
                coins-=costs[i];
                count++;
            }
            else
                break;
            i++;
        }
        return count;
    }
}