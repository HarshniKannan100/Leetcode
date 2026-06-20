class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{1,0});
        for(int[] v:restrictions){
            list.add(v);
        }
        for(int i=1;i<list.size();i++){
            int diff=list.get(i)[0]-list.get(i-1)[0];
            list.get(i)[1]=Math.min(list.get(i)[1],list.get(i-1)[1]+diff);
        }
        for(int i=list.size()-2;i>=0;i--){
            int diff=list.get(i+1)[0]-list.get(i)[0];
            list.get(i)[1]=Math.min(list.get(i)[1],list.get(i+1)[1]+diff);
        }
        int ans=0;
        for(int i=1;i<list.size();i++){
            int x1=list.get(i-1)[0];
            int h1=list.get(i-1)[1];
            int x2=list.get(i)[0];
            int h2=list.get(i)[1];
            int diff=x2-x1;
            ans=Math.max(ans,(h1+h2+diff)/2);
        }
        int lastx=list.get(list.size()-1)[0];
        int lasth=list.get(list.size()-1)[1];
        return Math.max(ans,lasth+(n-lastx));
    }
}