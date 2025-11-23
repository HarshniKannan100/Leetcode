class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> l1=new ArrayList<Integer>();
        List<Integer> l2=new ArrayList<Integer>();
        int sum=0;
        for(int v:nums){
            sum+=v;
            if(v%3==1) l1.add(v);
            else if(v%3==2) l2.add(v);
        }

        if(sum%3==0) return sum;

        Collections.sort(l1);
        Collections.sort(l2);
        int res=0;
        int rem=sum%3;
        if(rem==1){
            int a1=l1.size()>=1?sum-l1.get(0):0;
            int a2=l2.size()>=2?sum-l2.get(0)-l2.get(1):0;
            res=Math.max(a1,a2);
        }else{
            int a1=l2.size()>=1?sum-l2.get(0):0;
            int a2=l1.size()>=2?sum-l1.get(0)-l1.get(1):0;
            res=Math.max(a1,a2);
        }
        return res;
    }
}