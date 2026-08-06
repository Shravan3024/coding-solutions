# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 105
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Python  
**Runtime:** 273 ms (beats 20.00%)  
**Memory:** 16.9 MB (beats 7.09%)  
**Submitted:** 2026-08-06T07:21:21.937Z  

```py
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        last_seen = [-1] * 128

        left = 0
        max_len = 0

        for right in range(len(s)):

            ch = ord(s[right])

            if last_seen[ch] >= left:
                left = last_seen[ch] + 1

            last_seen[ch] = right

            max_len = max(max_len, right - left + 1)

        return max_len
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)