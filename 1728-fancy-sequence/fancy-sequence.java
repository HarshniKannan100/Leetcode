class Fancy {
    int MOD=1000000007;
    ArrayList<Long> list;
    long a,b;
    public Fancy() {
        list=new ArrayList<>();
        a=1;
        b=0; 
    }   
    
    private long modPow(long x,long y,long mod){
        long res=1;
        x=x%MOD;
        while(y>0){
            if(y%2==1){
                res=(res*x)%MOD;
            }
            y/=2;
            x=(x*x)%MOD;
        }
        return res;
    }
    public void append(int val) {
        long x=(val-b+MOD)%MOD;
        this.list.add((x*modPow(a,MOD-2,MOD))%MOD);
    }
    
    public void addAll(int inc) {
        b=(b+inc)%MOD;
    }
    
    public void multAll(int m) {
        a=(a*m)%MOD;
        b=(b*m)%MOD;
    }
    
    public int getIndex(int idx) {
        if(idx>=list.size()) return -1;
        return (int)((a*list.get(idx)+b)%MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */