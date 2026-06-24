class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        // Start from top-right corner
        int row = 0;
        int col = c - 1;

        while (row < r && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;  // too big → go left
            } else {
                row++;  // too small → go down
            }
        }
        return false;
    }
}