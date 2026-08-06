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