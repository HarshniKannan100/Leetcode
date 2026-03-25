import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0; 
        int n = weights.length;
        int[] pairs = new int[n - 1];
        for (int i=0;i<n-1;i++) {
            pairs[i]=weights[i] + weights[i + 1];
        }
        Arrays.sort(pairs);
        long minSum = 0, maxSum = 0;
        for (int i=0;i<k-1;i++) {
            minSum+=pairs[i];
        }
        for (int i=n-2;i>=n-k; i--) {
            maxSum+=pairs[i];
        }
        return maxSum-minSum;
    }
}
