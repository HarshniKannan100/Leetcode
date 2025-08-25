class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int R=mat.length, C=mat[0].length;
        int res[]=new int[R*C];
        int idx=0;
        List<List<Integer>> list=new ArrayList<>();
        int i=0,j=0;
        for(int r=0;r<C;r++){
            i=0;
            j=r;
            List<Integer> l=new ArrayList<>(); 
            while(i<R && j>=0){
                l.add(mat[i][j]);
                i+=1;
                j-=1;
            }
            list.add(l);
        }
        for(int r=1;r<R;r++){
            i=r;
            j=C-1;
            List<Integer> l=new ArrayList<>(); 
            while(i<R && j>=0){
                l.add(mat[i][j]);
                i+=1;
                j-=1;
            }
            list.add(l);
        }
        int k=0;
        for(List<Integer> l:list){
            if(k%2==0) Collections.reverse(l);
            k++;
            for(int n:l){
                res[idx++]=n;
            }
        }
        return res;
    }
}