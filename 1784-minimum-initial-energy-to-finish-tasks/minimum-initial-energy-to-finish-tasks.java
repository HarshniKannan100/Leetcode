class Solution {
    public int minimumEffort(int[][] tasks) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int[] v:tasks){
            min=Math.min(min,v[1]);
            sum+=v[1];
        }
        int l=min,r=sum,res=0;
        while(l<=r){
            int mid=(l+r)/2;
            boolean flag=true;
            final int t=mid;
            Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
            int temp=mid;
            for(int i=0;i<tasks.length;i++){
                if(temp<tasks[i][1]){
                    flag=false;
                    break;    
                }
                temp-=tasks[i][0];
            }
            if(flag){
                res=mid;
                r=mid-1; 
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}