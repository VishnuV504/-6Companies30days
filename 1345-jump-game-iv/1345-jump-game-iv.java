class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer>q=new LinkedList<>(); int n=arr.length;
        q.add(0); int steps=0; boolean visited[]=new boolean[n];visited[0]=true;
        HashMap<Integer,ArrayList<Integer>>hs=new HashMap<>();
        for(int i=0;i<n;i++){
            if(hs.containsKey(arr[i]))
                hs.get(arr[i]).add(i);
            else{
                ArrayList<Integer>li=new ArrayList<>();
                li.add(i);
                hs.put(arr[i],li);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
                int idx=q.peek();
                if(idx==n-1)return steps;
                q.remove();
                if(idx-1>=0&&visited[idx-1]==false){
                    visited[idx-1]=true;
                    q.add(idx-1);
                }
                if(idx+1<n&&visited[idx+1]==false){
                    visited[idx+1]=true;
                    q.add(idx+1);
                }
                if(hs.containsKey(arr[idx])){
                    for(int i=0;i<hs.get(arr[idx]).size();i++){
                        int curr=hs.get(arr[idx]).get(i);
                        if(visited[curr]==false){
                            q.add(curr);
                            visited[curr]=true;
                        }
                    }
                    hs.remove(arr[idx]);
                }
                size--; 
            }
            steps++;
        }
        return 0;
    }
}
