class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int max=0;
        for(int v:map.values()){
            max=Math.max(v,max);
        }
        int sum=0;
        for(int v:map.values()){
            if(v==max){
                sum+=v;
            }
        }
        return sum;
    }
}