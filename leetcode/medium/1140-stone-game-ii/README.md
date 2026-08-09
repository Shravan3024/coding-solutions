# Stone Game II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Alice and Bob continue their games with piles of stones. There are a number of piles  **arranged in a row**, and each pile has a positive integer number of stones `piles[i]`. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.

On each player's turn, that player can take  **all the stones**  in the  **first**  `X` remaining piles, where `1 <= X <= 2M`. Then, we set `M = max(M, X)`. Initially, M = 1.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

 

 **Example 1:** 

 **Input:**  piles = [2,7,9,4,4]

 **Output:**  10

 **Explanation:** 

- If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
- If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.

So we return 10 since it's larger.

 **Example 2:** 

 **Input:**  piles = [1,2,3,4,5,100]

 **Output:**  104

 

 **Constraints:** 

- 1 <= piles.length <= 100
- 1 <= piles[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 62.68%)  
**Memory:** 46.2 MB (beats 31.16%)  
**Submitted:** 2026-08-09T18:18:07.755Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-ii/)