class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0;

        for (int c : candies) {
            maxCandy = Math.max(maxCandy, c);
        }

        // if (sum(candies) < k) return 0; // Not enough candies

        int lo = 1, hi = maxCandy, best = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(mid, candies, k)) {
                best = mid;
                lo = mid + 1; // Try for a larger value
            } else {
                hi = mid - 1; // Reduce the value
            }
        }

        return best;
    }

    private boolean isPossible(int x, int[] candies, long k) {
        long count = 0;

        for (int c : candies) {
            count += c / x; // Count children that can be served
        }

        return count >= k;
    }
    
}