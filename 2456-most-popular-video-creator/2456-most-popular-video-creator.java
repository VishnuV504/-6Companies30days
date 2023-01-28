class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String,Long>hs1=new HashMap<>(); int n=creators.length; long max=0;
        HashMap<String,Integer>hs2=new HashMap<>();HashMap<String,String>hs3=new HashMap<>();
        List<List<String>>ans=new ArrayList<List<String>>();
        for(int i=0;i<n;i++){
            if(hs1.containsKey(creators[i]))
                hs1.put(creators[i],hs1.get(creators[i])+views[i]);
            else
                hs1.put(creators[i],(long)views[i]);
            
            if(hs2.containsKey(creators[i])){
                int prev=hs2.get(creators[i]);
                hs2.put(creators[i],Math.max(prev,views[i]));
                if((prev==views[i])){
                    String s=(hs3.get(creators[i])); String t=ids[i];
                    if(s.compareTo(t)>0)
                    hs3.put(creators[i],ids[i]);
                }
                else if(hs2.get(creators[i])>prev){
                    hs3.put(creators[i],ids[i]);
                }
            }
            else{
                hs2.put(creators[i],views[i]);
                hs3.put(creators[i],ids[i]);
            }
            max=Math.max(max,hs1.get(creators[i]));
        }
        for(String key:hs1.keySet()){
            if(hs1.get(key)==max){
                ArrayList<String>li=new ArrayList<>();
                li.add(key);
                li.add(hs3.get(key));
                ans.add(li);
            }
        }
        return ans;
    }
}