class Solution {
    public String addBinary(String a, String b) {
        int carry=0; StringBuilder  ans=new StringBuilder();int m=a.length(); int n=b.length();
        int i=m-1; int j=n-1;
        while(i>=0&&j>=0){
            int one=0; int two=0;
            if(a.charAt(i)=='1')
                one=1;
            if(b.charAt(j)=='1')
                two=1;
          //  System.out.println(one+" "+two+" "+carry);
            if(one==1&&two==1){
                if(carry==1)
                    ans.append("1");
                else
                    ans.append("0");
                carry=1;
            }
            else if(carry==1){
                if(one==1||two==1)
                ans.append("0");
                else{
                    carry=0;
                    ans.append("1");
                }
            }
            else if(one==1||two==1){
                ans.append("1");
                carry=0;
            }
            else{
                ans.append("0");
                carry=0;
            }
            i--;
            j--;
        }
        while(i>=0){
            if(carry==1){
                if(a.charAt(i)=='0'){
                    ans.append("1");
                    carry=0;
                }
                else
                    ans.append("0");
            }
            else if(a.charAt(i)=='0')
                ans.append("0");
            else
                ans.append("1");
            i--;
        }
        while(j>=0){
            if(carry==1){
                if(b.charAt(j)=='0'){
                    ans.append("1");
                    carry=0;
                }
                else
                    ans.append("0");
            }
            else if(b.charAt(j)=='0')
                ans.append("0");
            else 
                ans.append("1");
            j--;
        }
        if(carry==1)
            ans.append("1");
        return ans.reverse().toString();
    }
}