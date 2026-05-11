class Solution {
    public int[] separateDigits(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int count=0;
        for(int n:nums){
            List<Integer> c=new ArrayList<>();
            while(n>0){
                c.add(n%10);
                n/=10;
                count++;
            }
            Collections.reverse(c);
            list.add(c);
        }
       int[] arr=new int[count];
       int idx=0;
       for(List<Integer> l:list){
            for(int n:l){
                arr[idx++]=n;
            }
       }
       return arr;
    }
}