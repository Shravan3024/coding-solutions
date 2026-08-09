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
**Runtime:** 3 ms (beats 90.90%)  
**Memory:** 44.1 MB (beats 88.69%)  
**Submitted:** 2026-08-09T18:18:35.550Z  

```java
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n + 1];
        return dfs(piles, suffixSum, 0, 1, memo);
    }

    private int dfs(int[] piles, int[] suffixSum, int i, int M, int[][] memo) {
        if (i >= piles.length) return 0;
        if (i + 2 * M >= piles.length) return suffixSum[i];
        if (memo[i][M] != 0) return memo[i][M];

        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int opponentStones = dfs(piles, suffixSum, i + X, nextM, memo);
            maxStones = Math.max(maxStones, suffixSum[i] - opponentStones);
        }

        memo[i][M] = maxStones;
        return maxStones;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-ii/)