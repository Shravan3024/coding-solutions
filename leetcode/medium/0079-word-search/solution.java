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
