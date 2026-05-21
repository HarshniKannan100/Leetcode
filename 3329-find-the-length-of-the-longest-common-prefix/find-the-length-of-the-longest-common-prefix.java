class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int n:arr1){
            while(n>0){
                set.add(n);
                n/=10;
            }
        }
        int max=0;
        for(int n:arr2){
            while(n>0){
                if(set.contains(n)){
                    max=Math.max(max,Integer.toString(n).length());
                }
                n/=10;
            }
        }
        return max;
    }
}