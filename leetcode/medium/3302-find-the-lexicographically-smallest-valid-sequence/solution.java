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