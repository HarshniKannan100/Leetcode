class Solution {
    private int reverse(int x){
        int v=0;
        while(x>0){
            v*=10;
            v+=x%10;
            x/=10;
        }
        return v;
    }
    public int minMirrorPairDistance(int[] nums) {
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                min=Math.min(min,i-map.get(nums[i]));
            }
            map.put(reverse(nums[i]),i);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}