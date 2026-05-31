class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long s=mass;
        Arrays.sort(asteroids);
        for(int n:asteroids){
            if(s<n) return false;
            s+=n;
        }
        return true;
    }
}