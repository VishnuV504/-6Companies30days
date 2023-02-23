class Pair{
    int a;
    int b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Pair2 extends Pair{
    int d;
    Pair2(int d,int a,int b){
        super(a,b);
        this.d=d;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=capital.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }
        Arrays.sort(arr,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int i=0;
        PriorityQueue<Pair2>pq=new PriorityQueue<>((a,b)->Integer.compare(b.d,a.d));
        int ans=w;
        while(k>0){
            while(i<n&&(arr[i][0]<=w)){
                pq.add(new Pair2(arr[i][1],arr[i][0],arr[i][1]));
                i++;
            }
            if((!pq.isEmpty())&&pq.peek().a<=w){
                ans+=pq.peek().b;
                w+=pq.peek().b;
                k--;
            }
            else if(pq.isEmpty())return ans;
            pq.remove();
        }
        return ans;
    }
}