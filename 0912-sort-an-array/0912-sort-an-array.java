class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        solve(0,n-1,nums);
        return nums;
    }
    public void solve(int i,int j,int nums[]){
        if(i<j){
            int mid=i+(j-i)/2;
            solve(i,mid,nums);
            solve(mid+1,j,nums);
            merge(i,mid,j,nums);
        }
    }
    public void merge(int l,int mid,int r,int nums[]){
        ArrayList<Integer>li=new ArrayList<>();
        ArrayList<Integer>li2=new ArrayList<>(); int k=l; int n1=mid-l+1; int n2=r-mid;
        for (int i=0;i<n1;i++)
            li.add(nums[l+i]);
        for (int j=0;j<n2;j++)
            li2.add(nums[mid+1+j]);
        int i=0; int j=0; int m=li.size(); int n=li2.size();
        while(i<m&&j<n){
            if(li.get(i)<li2.get(j)){
                nums[k++]=li.get(i);
                i++;
            }
            else{
                nums[k++]=li2.get(j);
                j++;
            }
        }
        while(i<m){
            nums[k++]=li.get(i);
            i++;
        }
        while(j<n){
            nums[k++]=li2.get(j);
            j++;
        }
    }
}