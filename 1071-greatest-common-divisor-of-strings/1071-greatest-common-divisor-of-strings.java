class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m=str1.length(); int n=str2.length();
        int i=0; int j=0;
        while(i<m&&j<n){
            if(str1.charAt(i)!=str2.charAt(j))return new String("");
            i++;
            j++;
        }
        StringBuilder sb=new StringBuilder(); String ans="";
        for(i=0;i<m;i++){
            sb.append(str1.charAt(i));
            j=0; int k=0; int len=i+1; boolean flag=true; int a=0;
            if(m%len==0&&n%len==0){
                while(k<len&&j<n&&a<m){
                    if(str1.charAt(a)!=str2.charAt(j)||str2.charAt(j)!=sb.charAt(k)){
                        flag=false;
                        break;
                    }
                    a++;
                    j++;
                    k++;
                    k%=len;
                }
                while(j<n&&flag){
                    if(str2.charAt(j)!=sb.charAt(k)){
                        flag=false;
                        break;
                    }
                    j++;
                    k++;
                    k%=len;
                }
                while(a<m&&flag){
                    if(str1.charAt(a)!=sb.charAt(k)){
                        flag=false;
                        break;
                    }
                    a++;
                    k++;
                    k%=len;
                }
                if(flag)
                    ans=sb.toString();
            }
        }
        return ans;
    }
}