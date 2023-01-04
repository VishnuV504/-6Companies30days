class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer>hs=new HashMap<>(); int n=tasks.length; int count=0;
        for(int i=0;i<n;i++){
            if(hs.containsKey(tasks[i]))
                hs.put(tasks[i],hs.get(tasks[i])+1);
            else
                hs.put(tasks[i],1);
        }
        for(Integer key:hs.keySet()){
            if(hs.get(key)==1)return -1;
            int num=hs.get(key);
            if(num%3==0)count+=num/3;
            else if(num%3==1) count+=num/3+1;
            else count+=num/3+1;
        }
        return count;
    }
}