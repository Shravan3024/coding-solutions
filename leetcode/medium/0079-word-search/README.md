# Word Search

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `m x n` grid of characters `board` and a string `word`, return `true`  *if*  `word`  *exists in the grid*.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

 **Example 1:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

```

 **Example 2:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

```

 **Example 3:** 

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

```

 

 **Constraints:** 

- m == board.length
- n = board[i].length
- 1 <= m, n <= 6
- 1 <= word.length <= 15
- board and word consists of only lowercase and uppercase English letters.

 

 **Follow up:**  Could you use search pruning to make your solution faster with a larger `board`?

## Solution

**Language:** Java  
**Runtime:** 212 ms (beats 13.49%)  
**Memory:** 46.8 MB (beats 10.37%)  
**Submitted:** 2026-06-24T10:38:24.067Z  

```java
class Solution {
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean exist(char[][] board, String word) {
    Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0))queue.offer(new Pair(i,j));
            }
        }
        int n=board.length,m=board[0].length;
        for(Pair pair:queue){
            boolean[][]visited=new boolean[n][m];
            if(dfs(pair.x,pair.y,board,word,n,m,visited,0))return true;
        }
        return false;
    }
    public static boolean dfs(int row, int col, char[][]board, String target, int n, int m, boolean[][]visited, int index){
        if(index==target.length())return true;
        if(row<0||col<0||col>=m||row>=n||visited[row][col]||board[row][col]!=target.charAt(index))return false;
        visited[row][col]=true;
        int[]allowedRow={0,-1,1,0};
        int[]allowedCol={-1,0,0,1};
        for(int i=0;i<4;i++){
            int newRow=row+allowedRow[i];
            int newCol=col+allowedCol[i];
            if(dfs(newRow,newCol,board,target,n,m,visited,index+1))return true;
        }
        visited[row][col]=false;
        return false;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/word-search/)