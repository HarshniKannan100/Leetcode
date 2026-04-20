class Solution {
    public int maxDistance(int[] colors) {
        int max=0,n=colors.length;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[n-1]){
                max=n-1-i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(colors[i]!=colors[0]){
                return Math.max(max,i);
            }
        }
        return 0;
    }
}