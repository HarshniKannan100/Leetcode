class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int min=Integer.MAX_VALUE;
        for(List<Integer> v:map.values()){
            if(v.size()>=3){
                for(int i=0;i<v.size()-2;i++){
                    min=Math.min(min,(v.get(i+1)-v.get(i))+(v.get(i+2)-v.get(i+1))+(v.get(i+2)-v.get(i)));
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}