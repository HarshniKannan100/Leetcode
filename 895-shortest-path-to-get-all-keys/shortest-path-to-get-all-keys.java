class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int keyCount=0;
        int r=grid.length;
        int c=grid[0].length();
        Queue<int[]> q=new LinkedList<>();
        boolean visited[][][]=new boolean[r][c][(1<<6)];

        for(int s=0;s<r;s++){
            for(int ch=0;ch<c;ch++){
                char charr=grid[s].charAt(ch);
                if(Character.isLowerCase(charr)) keyCount++;
                else if(charr=='@'){
                    q.add(new int[]{s,ch,0,0});
                    visited[s][ch][0]=true;
                }
            }
        }
        int[][] diff={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int row=cell[0],col=cell[1],moves=cell[2],flag=cell[3];
            if(flag==((1<<keyCount)-1)) return moves;
            for(int i=0;i<4;i++){
                int ar=row+diff[i][0];
                int ac=col+diff[i][1];
                if(ar>=0 && ar<r && ac>=0 && ac<c){
                    char ch=grid[ar].charAt(ac);
                    if(ch=='#') continue;
                    if(Character.isUpperCase(ch)){
                        if((flag & (1<<(ch-'A')))==0){  // & is for checking if binary no. has 0 or 1 in that position
                            continue;
                        }
                    }
                    int newFlag=flag;
                    if(Character.isLowerCase(ch)){
                        newFlag= newFlag|(1<<ch-'a'); // | is for putting 1 in the binary no. in the alphabet's place from reverse
                    }

                    if(!visited[ar][ac][newFlag]){
                        q.add(new int[]{ar,ac,moves+1,newFlag});
                        visited[ar][ac][newFlag]=true;
                    }
                }
            }
        }
        return -1;
        
    }
}