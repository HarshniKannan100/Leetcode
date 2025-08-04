class Solution {
    public int totalFruit(int[] fruits) {
        int s=0,e=0;
        Map<Integer,Integer> map =new HashMap<>();
        int cur=0,max=0;
        while(e<fruits.length){
            map.put(fruits[e],map.getOrDefault(fruits[e],0)+1);
            while(map.size()>=3){
                map.put(fruits[s],map.get(fruits[s])-1);
                if(map.get(fruits[s])==0) map.remove(fruits[s]);
                s++;
            }
            cur=e-s+1;
            max=Math.max(cur,max);
            e++;
        }
        return max;
    }
}