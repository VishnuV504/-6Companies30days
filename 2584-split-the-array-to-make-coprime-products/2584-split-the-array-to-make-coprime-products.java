class Solution {
    public int findValidSplit(int[] arr) {
        int n=arr.length;HashMap<Integer,Long>suf=new HashMap<>();
        HashMap<Integer,Long>pre=new HashMap<>();
        for(int i=0;i<n;i++)
            preComp(arr[i],suf);
        int i=0;
        while(i<n-1){
            solve(arr[i],pre,suf);
            boolean flag=true;
            for(Integer key:pre.keySet()){
                if(suf.containsKey(key)){
                    flag=false;
                    break;
                }
            }
            if(flag)return i;
            i++;
        }
        return -1;
    }
    public static void solve(int n,HashMap<Integer,Long>pre,HashMap<Integer,Long>suf){
        while (n%2==0){
            if(pre.containsKey(2))pre.put(2,pre.get(2)+1l);
            else pre.put(2,1l);
            suf.put(2,suf.get(2)-1l);
            if(suf.get(2)==0)suf.remove(2);
            n /= 2;
        }
        for (int i=3;i<=Math.sqrt(n);i+=2){
            while (n%i==0){
                suf.put(i,suf.get(i)-1l);
                if(pre.containsKey(i))pre.put(i,pre.get(i)+1l);
                else pre.put(i,1l);
                if(suf.get(i)==0)suf.remove(i);
                n /= i;
            }
        }
        if(n>2){
            if(pre.containsKey(n))pre.put(n,pre.get(n)+1l);
            else pre.put(n,1l);
            suf.put(n,suf.get(n)-1l);
            if(suf.get(n)==0)suf.remove(n);
        }
    }
    public static void preComp(int n,HashMap<Integer,Long>suf){
        while (n%2==0){
            if(suf.containsKey(2))suf.put(2,suf.get(2)+1l);
            else suf.put(2,1l);
            n /= 2;
        }
        for (int i=3;i<=Math.sqrt(n);i+=2){
            while (n%i==0){
                if(suf.containsKey(i))suf.put(i,suf.get(i)+1l);
                else suf.put(i,1l);
                n /= i;
            }
        }
        if(n>2){
            if(suf.containsKey(n))suf.put(n,suf.get(n)+1l);
            else suf.put(n,1l);
        }
    }

}