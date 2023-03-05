class Solution {
    public int findValidSplit(int[] arr) {
        int n=arr.length;HashMap<Integer,Integer>suf=new HashMap<>();
        HashMap<Integer,Integer>pre=new HashMap<>();
        for(int i=0;i<n;i++)
            preComp(arr[i],suf,i);
        int i=0;
        while(i<n-1){
            solve(arr[i],pre,suf,i);
            boolean flag=true;
            for(Integer key:pre.keySet()){
                if(key!=1&&suf.containsKey(key)){
                    flag=false;
                    break;
                }
            }
            if(flag)return i;
            i++;
        }
        return -1;
    }
    public static void solve(int n,HashMap<Integer,Integer>pre,HashMap<Integer,Integer>suf,int idx){
        for (int i=1;i*i<=n;i++){
            if(n%i==0){
                if(suf.get(i)==idx)suf.remove(i);
                pre.put(i,idx);
                if(i!=n/i){
                    pre.put(n/i,idx);
                    if(suf.get(n/i)==idx)suf.remove(n/i);
                }

            }
        }
    }
    public static void preComp(int n,HashMap<Integer,Integer>suf,int idx){
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                suf.put(i,idx);
                if(i!=n/i)suf.put(n/i,idx);
            }
        }
    }

}