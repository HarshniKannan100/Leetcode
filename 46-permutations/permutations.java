class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(res,temp,nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if(temp.size()==nums.length){
            res.add(new ArrayList (temp));
            
        }
        for(int n:nums){
            if(!temp.contains(n)){
                temp.add(n);
                backtrack(res,temp,nums);
                temp.remove(temp.size()-1);
                
            }
        }return;
    }
}