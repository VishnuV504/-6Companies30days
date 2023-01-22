class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles); int n=piles.length;
        int i=0; int j=n-2; int sum=0;
        while(j>i){
            sum+=piles[j];
            j-=2;
            i++;
        }
        return sum;
    }
}