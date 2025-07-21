class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] ch:board) Arrays.fill(ch,'.');
        build(board,0,res);
        return res;
    }

    private void build(char[][] board,int row,List<List<String>> res){
        if(board.length==row){
            List<String> list=new ArrayList<>();
            for(char[] ch:board){
                list.add(new String(ch));
            }
            res.add(list);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                build(board,row+1,res);
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(char[][] board,int row,int col){
       

        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q') return false;
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q') return false;
        }

        for(int i=row-1,j=col+1; i>=0 && j<board.length ; i--,j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
}