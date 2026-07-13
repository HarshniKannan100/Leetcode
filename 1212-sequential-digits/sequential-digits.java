class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        int l=Integer.toString(low).length();
        int h=Integer.toString(high).length();
        int sl=low/((int)Math.pow(10,l-1));
        int sh=high/(int)Math.pow(10,h-1);
        for(int j=l;j<=h;j++){
            int i=sl,to=sh;
            if(j<h){
                to=9;
            }
            if(j>l){
                i=1;
            }
            while(i<=to){
                int[] dp=new int[j+1];
                int[] dp1=new int[j+1];
                int start=i;
                int limit=sh;
                int idx=1;
                dp[0]=i-1;
                dp1[0]=i-1;
                System.out.println(sl+" "+sh+" f");
                while(start<=limit || j<h){
                    System.out.println(start+" "+limit+" hi");
                    dp[idx]=dp[idx-1]+1;
                    dp1[idx]=start;
                    idx++;
                    if(idx==j) break;
                    start=(dp1[idx-1]*10)+dp[idx-1]+1;
                    limit=high/(int)Math.pow(10,h-idx);
                }
                if(idx==j){
                    System.out.println(start+" "+limit);
                    if(start<=limit || j<h) dp[idx]=dp[idx-1]+1;
                    int num=0;
                    boolean flag=false;
                    for(int k=1;k<=j;k++){
                        if(dp[k]==0 || dp[k]>9){
                            flag=true;
                            break;
                        }
                        num*=10;
                        num=num+dp[k];
                    }
                    if(!flag && num<=high && num>=low) list.add(num);
                }
                i++;

            }
        }
        return list;
    }
}