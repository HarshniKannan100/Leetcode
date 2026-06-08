class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int pc=0;
        int[] arr=new int[nums.length];
        int idx=0;
        for(int n:nums){
            if(n<pivot){
                arr[idx++]=n;
            }else if(n==pivot) pc++;
        }
        for(int i=0;i<pc;i++){
            arr[idx++]=pivot;
        }
        for(int n:nums){
            if(n>pivot) arr[idx++]=n;
        }
        return arr;
    }
}