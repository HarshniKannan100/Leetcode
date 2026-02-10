class NumArray {
    int[] st;
    int n,v;
    public NumArray(int[] nums) {
        if(nums.length>0){
            n=nums.length;
            int log=0;
            while((1<<log)<n) log++;
            v=(1<<log);
            st=new int[2*v];
            for(int i=0;i<n;i++){
                st[i+v]=nums[i];
            }
            for(int i=v-1;i>0;i--){
                st[i]=st[2*i]+st[2*i+1];
            }
        }
    }
    
    public void update(int index, int val) {
        int pos=v+index;
        st[pos]=val;
        while(pos>1){
            pos/=2;
            st[pos]=st[pos*2]+st[pos*2+1];
        }
    }
    
    public int sumRange(int left, int right) {
        return findsum(1,0,v-1,left,right);
    }
    public int findsum(int node,int nl,int nr,int ql,int qr){
        if(qr<nl || nr<ql) return 0;
        if(nl>=ql && nr<=qr) return st[node];
        int mid=(nl+nr)/2;
        int left=findsum(2*node,nl,mid,ql,qr);
        int right=findsum(2*node+1,mid+1,nr,ql,qr);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */