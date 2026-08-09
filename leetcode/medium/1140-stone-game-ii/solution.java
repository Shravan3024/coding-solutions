class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum from i to n-1
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n + 1][n + 1];

        /*
         * best1[i][m]:
         * min(dp[i+x][m]) for 1 <= x <= m
         *
         * best2[i][m]:
         * min(dp[i+x][x]) for m < x <= 2m
         */

        int[][] best1 = new int[n + 1][n + 1];
        int[][] best2 = new int[n + 1][n + 1];

        for (int i = n; i >= 0; i--) {

            for (int m = n; m >= 1; m--) {

                if (i >= n) {
                    dp[i][m] = 0;
                    continue;
                }

                // Can take all remaining piles
                if (i + 2 * m >= n) {
                    dp[i][m] = suffix[i];
                    continue;
                }

                int minOpponent = Integer.MAX_VALUE;

                /*
                 * X <= M
                 *
                 * dp[i+X][M]
                 */
                for (int x = 1; x <= m && i + x < n; x++) {
                    minOpponent = Math.min(
                        minOpponent,
                        dp[i + x][m]
                    );
                }

                /*
                 * X > M
                 *
                 * dp[i+X][X]
                 */
                for (int x = m + 1; x <= 2 * m && i + x < n; x++) {
                    minOpponent = Math.min(
                        minOpponent,
                        dp[i + x][x]
                    );
                }

                dp[i][m] = suffix[i] - minOpponent;
            }
        }

        return dp[0][1];
    }
}