class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=0;
        long sum=0;
        for(int n:nums) sum+=n;
        long rem=sum%p;
        if(rem==0) return 0;
        long cur=0;
        int res=nums.length;
        map.put(0,-1);
        while(r<nums.length){
            cur=(cur+nums[r])%p;
            int need=(int)((cur-rem+p)%p);
            if(map.containsKey(need)){
                res=Math.min(res,r-map.get(need));
            }
            map.put((int)cur,r);
            r++;
        }
        return res==nums.length?-1:res;
    }
}