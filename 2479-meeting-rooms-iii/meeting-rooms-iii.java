class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long busy[]= new long[n];
        int count[] =new int[n];

        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        for(int meeting[]:meetings){
            long earliest=Long.MAX_VALUE;
            boolean assigned=false;
            int roomIndex=-1;
            int start=meeting[0],end=meeting[1];
            for(int i=0;i<n;i++){
                if(busy[i]<earliest){
                    earliest=busy[i];
                    roomIndex=i;
                }

                if(busy[i]<=start){
                    busy[i]=end;
                    count[i]++;
                    assigned=true;
                    break;
                }
            }
            if(!assigned){
                busy[roomIndex]+=(end-start);
                count[roomIndex]++;
            }
        }

        int max=0,res=0;
        for(int i=0;i<n;i++){
            if(count[i]>max){
                max=count[i];
                res=i;
            }
        }
        return res;
    }
}