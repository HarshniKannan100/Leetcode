class Solution {
    public double angleClock(int hour, int minutes) {
        double minangle=6.0*minutes;
        double hourangle=30.0*(hour%12)+(0.5*minutes);
        double diff=Math.abs(hourangle-minangle);
        return Math.min(diff,360.0-diff);
    }
}