class Solution {
    static List<List<Integer>> list=new ArrayList<>();
    void dfs(int idx,int sum,List<Integer> cur,int[] arr,int tar){
        if(sum==tar){
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(sum+arr[i]>tar) break;
            cur.add(arr[i]);
            dfs(i+1,sum+arr[i],cur,arr,tar);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list.clear();
        Arrays.sort(candidates);
        dfs(0,0,new ArrayList<>(),candidates,target);
        return list;
    }
}
