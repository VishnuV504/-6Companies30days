class Solution {
    public int xorBeauty(int[] nums) {
        int xor=0; int n=nums.length;
        for(int i=0;i<n;i++)
            xor^=nums[i];//i=j=k
        HashMap<Integer,Integer>hs=new HashMap<>();
            //i==j&&k=something
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=0;j<32;j++){
                int bit=(1&(num>>j));
                if(bit==1){
                    if(hs.containsKey(j))
                        hs.put(j,hs.get(j)+1);
                    else
                        hs.put(j,1);
                }
            }
        }
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=0;j<32;j++){
                int bit=(1&(num>>j));
                if(bit==1){
                    if(((hs.get(j)-1)%2)==1)
                        xor^=(1<<j);
                }
            }
        }
        //i!=j!=k
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=0;j<32;j++){
                int bit=(1&(num>>j));
                if(bit==1){
                    if((n-1)%2==1)
                        xor^=(1<<j);
                }
                else{
                    if(hs.containsKey(j)){
                        if(hs.get(j)%2==1)
                        xor^=(1<<j);
                    }
                }
            }
        }
        return xor;
    }
}