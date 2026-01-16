class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hlist=new ArrayList<>();
        List<Integer> vlist=new ArrayList<>();
        hlist.add(1);
        hlist.add(m);
        vlist.add(1);
        vlist.add(n);
        for(int i=0;i<hFences.length;i++){
            hlist.add(hFences[i]);
        }
        for(int i=0;i<vFences.length;i++){
            vlist.add(vFences[i]);
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<hlist.size();i++){
            for(int j=i+1;j<hlist.size();j++){
                set.add(Math.abs(hlist.get(i)-hlist.get(j)));
            }
        }
        long max=0;
        for(int i=0;i<vlist.size();i++){
            for(int j=i+1;j<vlist.size();j++){
                int v=Math.abs(vlist.get(i)-vlist.get(j));
                if(set.contains(v)){
                    max=Math.max(max,v);
                }
            }
        }
        if(max==0) return -1;
        return (int)((max*max)%1000000007);
    }
}