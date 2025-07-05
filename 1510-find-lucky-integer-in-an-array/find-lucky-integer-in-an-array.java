class Solution {
    public int findLucky(int[] arr) {
        int[] freq=new int[501];
        for(int ind=0;ind<arr.length;ind++){
            freq[arr[ind]]++;
        }

        for(int ind=500;ind>=1;ind--){
            if(ind==freq[ind]) return ind;
        }
        return -1;
    }
}