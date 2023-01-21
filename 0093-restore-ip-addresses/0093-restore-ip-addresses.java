class Solution {
    List<String>ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        solve(0,0,s,0,-1,new StringBuilder());
        return ans;
    }
    public void solve(int curr,int parts,String s,int val,int prev,StringBuilder sb){
        if(curr==s.length()){
            if(parts==4&&prev==-1)
                ans.add(sb.toString());
            return;
        }
        if(parts>3)return;
        int num=(int)(s.charAt(curr)-'0');
        if((val*10+num)<=255&&((prev==0&&prev!=num)||prev!=0||val>0)){
            if(prev==-1&&num==0){
                sb.append("0");
                if(curr+1!=s.length())
                    sb.append(".");
                solve(curr+1,parts+1,s,0,-1,sb);
                if(curr+1!=s.length())
                    sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(s.charAt(curr));
                solve(curr+1,parts,s,val*10+num,num,sb);
                sb.deleteCharAt(sb.length()-1);

                sb.append(s.charAt(curr));
                if(curr+1!=s.length())
                    sb.append(".");
                solve(curr+1,parts+1,s,0,-1,sb);
                if(curr+1!=s.length())
                    sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
    }
}
