class Node{
    int prevIdx;
    long sum;
    int count;
    Node(int prevIdx,long sum,int count){
        this.prevIdx=prevIdx;
        this.sum=sum;
        this.count=count;
    }
}
class Solution {
    public long[] create(int v,long[] arr,int[] nums){
        Map<Integer,Node> map=new HashMap<>();
        int i=v;
        while(true){
            if(i>=nums.length || i<0) return arr;
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new Node(i,0,1));
            }else{
                Node nn=map.get(nums[i]);
                nn.sum+=(nn.count*Math.abs(i-nn.prevIdx));
                nn.count++;
                nn.prevIdx=i;
                map.put(nums[i],nn);
            }
            arr[i]+=map.get(nums[i]).sum;
            i+=(v==0)?1:-1;
        }
    }
    public long[] distance(int[] nums) {
        long[] arr=new long[nums.length];
        create(0,arr,nums);
        create(nums.length-1,arr,nums);
        return arr;
    }
}