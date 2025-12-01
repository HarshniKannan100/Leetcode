class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long total=0;
        for(int b:batteries) total+=b;
        int i=batteries.length-1,k=0;
        while(batteries[i]>(total/(n-k))){
            k++;
            total-=batteries[i];
            i--;
        }
        return total/(n-k);
    }
}