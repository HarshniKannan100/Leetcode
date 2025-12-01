class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long total=0;
        for(int b:batteries) total+=b;
        int i=batteries.length-1;
        while(batteries[i]>(total/(n))){
            total-=batteries[i];
            i--;
            n--;
        }
        return total/(n);
    }
}