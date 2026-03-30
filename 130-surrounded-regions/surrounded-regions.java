class Solution {
    static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int i,int j,char[][] board,int R,int C){
        if(i<0 || i>=R || j<0 || j>=C || board[i][j]!='O') return;
        board[i][j]='T';
        for(int[] d:dir){
            dfs(i+d[0],j+d[1],board,R,C);
        }
    }
    public void solve(char[][] board) {
        int R=board.length,C=board[0].length;
        boolean[][] vis=new boolean[R][C];
        for(int i=0;i<R;i++){
            if(board[i][0]=='O') dfs(i,0,board,R,C);
            if(board[i][C-1]=='O') dfs(i,C-1,board,R,C);
        }
        for(int i=0;i<C;i++){
            if(board[0][i]=='O') dfs(0,i,board,R,C);
            if(board[R-1][i]=='O') dfs(R-1,i,board,R,C);
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='T') board[i][j]='O';
            }
        }
    }
}
