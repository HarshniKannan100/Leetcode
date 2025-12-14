class Solution {
    public int numberOfWays(String corridor) {
        int Scount=0;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S') Scount++;
        }
        if(Scount%2!=0 || Scount==0) return 0;
        long tot=1;
        int idx=0,two=0,Pcount=1;
        while(idx<corridor.length()){
            if(two==2 && corridor.charAt(idx)=='S'){
                two=1;
                tot=(tot*(Pcount))%1000000007;
                Pcount=1;
            }
            else if(two==2){
                Pcount++;
            }
            else if(corridor.charAt(idx) == 'S'){
                two++;
            }
            idx++;
        }
        return (int)tot;
    }
}