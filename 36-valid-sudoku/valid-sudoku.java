class Solution {
    public boolean isValidSudoku(char[][] board) {
        int R=board.length;
        int C=board[0].length;
        int SIZE=9;
        int SMSIZE=3;
        int rowa[]=new int[SIZE];
        int cola[]=new int[SIZE];
        int submat[]=new int[SIZE];
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.'){
                    int dig=board[row][col]-'0';
                    int subdix= SMSIZE*(row/SMSIZE)+(col/SMSIZE);
                    if(((rowa[row]&(1<<dig))!=0) || ((cola[col]&(1<<dig))!=0 )|| ((submat[subdix]&(1<<dig))!=0)){
                        return false;
                    }
                    rowa[row]|=(1<<dig);
                    cola[col]|=(1<<dig);
                    submat[subdix]|=(1<<dig);
                }
            }
        }
        return true;
    }
}