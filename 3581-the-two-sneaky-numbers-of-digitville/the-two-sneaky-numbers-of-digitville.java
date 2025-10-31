class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq=new int[nums.length-2];
        int[] res=new int[2];
        Arrays.fill(res,-1);
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]==2){
                if(res[0]==-1) res[0]=nums[i];
                else{
                    res[1]=nums[i];
                    return res;
                }
            }
        }
        return res; 
    }
}