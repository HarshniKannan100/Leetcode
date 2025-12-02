class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[1], k -> new ArrayList<>()).add(point[0]);
        }

        List<Long> segments = new ArrayList<>();
        for (List<Integer> xlist : map.values()) {
            int count = xlist.size();
            if (count >= 2) {
                long seg = (1L * count * (count - 1)) / 2;
                segments.add(seg);
            }
        }

        // Use math trick: (sum^2 - sum_of_squares) / 2
        long sum = 0, sumSquares = 0;
        for (long seg : segments) {
            sum = (sum + seg) % mod;
            sumSquares = (sumSquares + seg * seg % mod) % mod;
        }

        long total = (sum * sum % mod - sumSquares + mod) % mod;
        total = (total * inv(2, mod)) % mod;

        return (int) total;
    }

    // Modular inverse of 2 mod 1e9+7 is 500000004
    private long inv(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
