class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max=Integer.MIN_VALUE;
        int[] pre=new int[energy.length];
        for(int i=energy.length-1;i>=0;i--){
            if(i+k<energy.length)
                pre[i]=energy[i]+pre[i+k];
            else pre[i]=energy[i];
            max=Math.max(max,pre[i]);
        }
        
        return max;
    }
}