# Find the Lexicographically Smallest Valid Sequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `word1` and `word2`.

A string `x` is called  **almost equal**  to `y` if you can change  **at most**  one character in `x` to make it  *identical*  to `y`.

A sequence of indices `seq` is called  **valid**  if:

- The indices are sorted in ascending order.
- Concatenating the characters at these indices in word1 in the same order results in a string that is almost equal to word2.

Return an array of size `word2.length` representing the lexicographically smallest  **valid**  sequence of indices. If no such sequence of indices exists, return an  **empty**  array.

 **Note**  that the answer must represent the  *lexicographically smallest array*,  **not**  the corresponding string formed by those indices.

 

 **Example 1:** 

 **Input:**  word1 = "vbcca", word2 = "abc"

 **Output:**  [0,1,2]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[0, 1, 2]`:

- Change word1[0] to 'a'.
- word1[1] is already 'b'.
- word1[2] is already 'c'.

 **Example 2:** 

 **Input:**  word1 = "bacdc", word2 = "abc"

 **Output:**  [1,2,4]

 **Explanation:** 

The lexicographically smallest valid sequence of indices is `[1, 2, 4]`:

- word1[1] is already 'a'.
- Change word1[2] to 'b'.
- word1[4] is already 'c'.

 **Example 3:** 

 **Input:**  word1 = "aaaaaa", word2 = "aaabc"

 **Output:**  []

 **Explanation:** 

There is no valid sequence of indices.

 **Example 4:** 

 **Input:**  word1 = "abc", word2 = "ab"

 **Output:**  [0,1]

 

 **Constraints:** 

- 1 <= word2.length < word1.length <= 3 * 105
- word1 and word2 consist only of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 31 ms (beats 97.22%)  
**Memory:** 137.7 MB (beats 22.22%)  
**Submitted:** 2026-08-08T18:26:47.826Z  

```java
class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suffix[i] = latest index in word1 from which
        // word2[i..m-1] can be matched exactly.
        int[] suffix = new int[m];
        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }

            if (p < 0) {
                suffix[j] = -1;
            } else {
                suffix[j] = p;
                p--;
            }
        }

        int[] ans = new int[m];

        int prev = -1;
        boolean changed = false;

        for (int j = 0; j < m; j++) {

            boolean found = false;

            for (int k = prev + 1; k < n; k++) {

                // Case 1: Characters are already equal.
                if (word1.charAt(k) == word2.charAt(j)) {
                    ans[j] = k;
                    prev = k;
                    found = true;
                    break;
                }

                // Case 2: Use our one allowed modification.
                if (!changed) {
                    // Remaining characters must be matched exactly.
                    if (j == m - 1 || 
                        (suffix[j + 1] != -1 && suffix[j + 1] > k)) {

                        ans[j] = k;
                        prev = k;
                        changed = true;
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/)