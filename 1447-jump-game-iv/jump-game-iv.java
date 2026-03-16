class Solution {
    public int minJumps(int[] arr) {
        if(arr.length==1) return 0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],new ArrayList<>());
        }                        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int count=0;
        while(!q.isEmpty()){
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int j=q.poll();
                if(j-1>=0 && map.containsKey(arr[j-1])){
                    q.add(j-1);
                }
                if(j+1<arr.length && map.containsKey(arr[j+1])){
                    if(j+1==arr.length-1) return count;
                    q.add(j+1);
                }
                if(map.containsKey(arr[j])){
                    for(int v:map.get(arr[j])){
                        if(v!=j){
                            if(v==arr.length-1) return count;
                            q.add(v);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }
        return count;
    }
}