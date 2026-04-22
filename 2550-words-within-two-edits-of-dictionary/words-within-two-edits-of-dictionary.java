class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        for(String s:queries){
            for(String ss:dictionary){
                if(s.equals(ss)){
                    res.add(s);
                    break;
                }else{
                    int count=0;
                    boolean flag=true;
                    for(int i=0;i<s.length();i++){
                        if(s.charAt(i)!=ss.charAt(i)) count++;
                        if(count>2){
                            flag=false;
                            break;
                        }
                    }
                    if(!flag) continue;
                    res.add(s);
                    break;
                }
            }
        }
        return res;
    }
}