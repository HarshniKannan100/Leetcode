class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res=new HashSet<>();
        Set<Integer> cur=new HashSet<>();
        for(int x:arr){
            Set<Integer> next=new HashSet<>();
            next.add(x);
            for(int y:cur){
                next.add(x|y);
            }
            res.addAll(next);
            cur=next;
        }
        return res.size();
    }
}