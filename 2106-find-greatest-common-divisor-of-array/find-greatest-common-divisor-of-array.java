class Solution {
    public int findGCD(int[] nums) {
        int s=Integer.MAX_VALUE,l=0;
        for(int i=0;i<nums.length;i++){
            s=Math.min(s,nums[i]);
            l=Math.max(l,nums[i]);
        }
        return gcd(s,l);
    }

    private int gcd(int s, int l){
        if(s%l==0) return l;
        return gcd(l,s%l);
    }
}