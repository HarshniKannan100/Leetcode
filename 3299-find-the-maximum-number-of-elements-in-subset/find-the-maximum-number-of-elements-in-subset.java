class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            set.add(n);
        }
        int max=1;
        for(int n:set){
            if(n==1){
                max=map.get(1)%2==0?map.get(1)-1:map.get(1);
                continue;
            }
            int cur=n;
            int val=0;
            if(map.get(cur)<2) continue;
            boolean flag=false;
            while(map.containsKey(cur)){
                if(map.get(cur)>=2){
                    val+=2;
                }else{
                    val++;
                    flag=true;
                    break;
                }
                cur*=cur;
            }
            if(!flag) val--;
            max=Math.max(max,val);
        }
        return max;
    }
}