class Solution {
    public int minFlips(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        int state=0;
        for(int row=0;row<r;row++){
            for(int col=0;col<c;col++){
                state=state | (mat[row][col] << (row*c+col));
            }
        }

        Queue<Integer> queue= new LinkedList<>();
        queue.add(state);
        Set<Integer> visited = new HashSet<>();
        visited.add(state);
        int count=0;
        int diff[][]={{-1,0},{1,0},{0,-1},{0,1},{0,0}};
        while(!queue.isEmpty()){
            int qsize=queue.size();
            for(int ctr=1;ctr<=qsize;ctr++){
                int cur = queue.poll();
                if (cur == 0){
                                return count;
                            }
                for(int row=0;row<r;row++){
                    for(int col=0;col<c;col++){
                        int newState = cur;
                        for(int i=0;i<5;i++){
                            int ar=row+diff[i][0];
                            int ac=col+diff[i][1];
                            if(ar>=0 && ar<r && ac>=0 && ac<c){
                                newState = newState ^ (1<< (ar*c +ac));
                            }
                        }
                        if(!visited.contains(newState)){
                            visited.add(newState);
                            queue.add(newState);
                            
                        }
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
}