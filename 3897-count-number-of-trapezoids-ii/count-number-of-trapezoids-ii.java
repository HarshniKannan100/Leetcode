class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Map<Integer,Integer>> t=new HashMap<>();
        Map<Integer, Map<Integer,Integer>> v=new HashMap<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                if(dx<0 || (dx==0 &&dy<0)){
                    dx=-dx;
                    dy=-dy;
                }

                int g=gcd(dx,Math.abs(dy));
                int sx=dx/g;
                int sy=dy/g;

                int des=sx*points[i][1]-sy*points[i][0];

                int k1=(sx<<12)|(sy+2000);
                int k2=(dx<<12)|(dy+2000);

                t.computeIfAbsent(k1, k ->new HashMap<>()).merge(des,1,Integer::sum);
                v.computeIfAbsent(k2, k ->new HashMap<>()).merge(des,1,Integer::sum);
            }
        }
        return count(t)-count(v)/2;
    }

    private int count(Map<Integer,Map<Integer,Integer>> map){
        long ans=0;
        for(Map<Integer,Integer> val:map.values()){
            long sum=0;
            for(int v:val.values()){
                sum+=v;
            }
            for(int v:val.values()){
                sum-=v;
                ans+=(long)v*sum;
            }
        } 
        return (int) ans;
    }

    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}