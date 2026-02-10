class NumArray {
    int[] st;
    int n,v;
    public NumArray(int[] nums) {
        n=nums.length;
        int log=0;
        while((1<<log)<n){
            log++;
        }
        v=(1<<log);
        st=new int[2*v];
        for(int i=0;i<n;i++){
            st[i+v]=nums[i];
        }
        for(int i=v-1;i>0;i--){
            st[i]=st[i*2+1]+st[i*2];
        }
    }
    
    public int sumRange(int left, int right) {
        return findsum(1,0,v-1,left,right);
    }
    public int findsum(int node,int nl,int nr,int ql,int qr){
        if(qr<nl || ql>nr) return 0;
        if(qr>=nr && ql<=nl) return st[node];
        int mid=(nl+nr)/2;
        int left=findsum(2*node,nl,mid,ql,qr);
        int right=findsum(2*node+1,mid+1,nr,ql,qr);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */