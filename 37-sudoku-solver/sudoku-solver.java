class Cell{
    int row,col;
    Cell(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    
    public void solveSudoku(char[][] board) {
        int R=board.length;
        int C=board[0].length;
        int rowa[]=new int[R];
        int cola[]=new int[C];
        int submat[]=new int[R];
        int SUBMATSIZE=3;
        int SIZE=board.length;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]!='.'){
                    int dig=board[row][col]-'0';
                    int subin=SUBMATSIZE*(row/SUBMATSIZE)+(col/SUBMATSIZE);
                    rowa[row]|=(1<<dig);
                    cola[col]|=(1<<dig);
                    submat[subin]|=(1<<dig);
                }
            }
        }
        solve(R,C,SUBMATSIZE,board,rowa,cola,submat);
    }
    private Cell getUnfilled(char[][] board,int R,int C){
            for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(board[row][col]=='.'){
                    return new Cell(row,col);
                }
            }
            }
            return null;
        }
    private boolean solve(int R,int C,int SUBMATSIZE,char[][] board,int[] rowa,int[] cola,int[] submat){
        Cell toFill=getUnfilled(board,R,C);
        if(toFill==null){
            return true;
        }
        int submati=SUBMATSIZE*(toFill.row/SUBMATSIZE)+(toFill.col/SUBMATSIZE);
        for(int dig=1;dig<=9;dig++){
            if((rowa[toFill.row]&(1<<dig))==0 && (cola[toFill.col]&(1<<dig))==0 && (submat[submati]&(1<<dig))==0){
                board[toFill.row][toFill.col]=(char)('0'+dig);
                rowa[toFill.row]|=(1<<dig);
                cola[toFill.col]|=(1<<dig);
                submat[submati]|=(1<<dig);
                boolean solved=solve(R,C,SUBMATSIZE,board,rowa,cola,submat);
                if(solved){
                    return true;
                }
                board[toFill.row][toFill.col]='.';
                rowa[toFill.row]^=(1<<dig);
                cola[toFill.col]^=(1<<dig);
                submat[submati]^=(1<<dig);
            }
        }
        return false;
    }
}