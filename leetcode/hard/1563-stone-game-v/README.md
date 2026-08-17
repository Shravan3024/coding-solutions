# Stone Game V

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are several stones  **arranged in a row**, and each stone has an associated value which is an integer given in the array `stoneValue`.

In each round of the game, Alice divides the row into  **two non-empty rows**  (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.

The game ends when there is only  **one stone remaining**. Alice's score is initially  **zero**.

Return  *the maximum score that Alice can obtain*.

 

 **Example 1:** 

```
Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.

```

 **Example 2:** 

```
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28

```

 **Example 3:** 

```
Input: stoneValue = [4]
Output: 0

```

 

 **Constraints:** 

- 1 <= stoneValue.length <= 500
- 1 <= stoneValue[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 95.67%)  
**Memory:** 52.8 MB (beats 5.05%)  
**Submitted:** 2026-08-17T09:33:13.920Z  

```java
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        int[][] leftBest = new int[n][n];

        int[][] rightBest = new int[n][n];

        int[] leftPtr = new int[n];

        int[] rightPtr = new int[n];

        for (int i = 0; i < n; i++) {
            leftBest[i][i] = stoneValue[i];
            rightBest[i][i] = stoneValue[i];

            leftPtr[i] = i - 1;

            rightPtr[i] = i;
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;

                long total = prefix[r + 1] - prefix[l];

                while (leftPtr[l] + 1 <= r - 1) {
                    int k = leftPtr[l] + 1;
                    long leftSum = prefix[k + 1] - prefix[l];

                    if (2 * leftSum > total) {
                        break;
                    }

                    leftPtr[l]++;
                }

                while (rightPtr[l] <= r - 1) {
                    int k = rightPtr[l];
                    long leftSum = prefix[k + 1] - prefix[l];

                    if (2 * leftSum >= total) {
                        break;
                    }

                    rightPtr[l]++;
                }

                int best = 0;

                if (leftPtr[l] >= l) {
                    best = leftBest[l][leftPtr[l]];
                }

                if (rightPtr[l] <= r - 1) {
                    best = Math.max(best, rightBest[rightPtr[l] + 1][r]);
                }

                dp[l][r] = best;

                leftBest[l][r] = Math.max(
                    leftBest[l][r - 1],
                    dp[l][r] + (int) total
                );

                rightBest[l][r] = Math.max(
                    rightBest[l + 1][r],
                    dp[l][r] + (int) total
                );
            }
        }

        return dp[0][n - 1];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-v/)