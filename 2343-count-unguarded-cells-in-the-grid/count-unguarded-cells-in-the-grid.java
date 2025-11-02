class Solution {
    static void func(int row,int col,int[][] mat,int m,int n){
        int i=row+m,j=col+n;
        while(i>=0 && i<mat.length && j>=0 && j<mat[0].length){
            if(mat[i][j]==-2) break;
            mat[i][j]=-1;
            i+=m;
            j+=n;
        }
        return;
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int[][] mat=new int[m][n];
    for(int i=0;i<guards.length;i++){
        mat[guards[i][0]][guards[i][1]]=-2;
    } 
    for(int i=0;i<walls.length;i++){
        mat[walls[i][0]][walls[i][1]]=-2;
    }   
    int[][] vis=new int[m][n];
    for(int c=0;c<guards.length;c++){
        mat[guards[c][0]][guards[c][1]]=-2;
        int[][] diff={{0,1},{1,0},{-1,0},{0,-1}};
        for(int v=0;v<4;v++){
            int i=guards[c][0]+diff[v][0],j=guards[c][1]+diff[v][1];
            while(i>=0 && i<mat.length && j>=0 && j<mat[0].length){
                if(mat[i][j]==-2) break;
                mat[i][j] = 1;
                i+=diff[v][0];
                j+=diff[v][1];
            }
        }
    }
    int count=0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0) count++;
        }
    } 
    return count;
}
}