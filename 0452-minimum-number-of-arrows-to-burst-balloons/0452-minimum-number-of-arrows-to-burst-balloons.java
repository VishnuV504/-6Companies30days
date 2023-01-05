class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->(a[0]-b[0])); int n=points.length;
        int start=points[0][0];int end=points[0][1]; int count=1;
        for(int i=1;i<n;i++){
            if(points[i][0]>=start&&points[i][0]<=end){
                start=points[i][0];
                end=Math.min(points[i][1],end);
            }
            else{
                start=points[i][0];
                end=points[i][1];
                count++;
            }
        }
        return count;
        
    }
}