class Solution {
    public int findLucky(int[] arr) {
        int lucky=-1;
        Map<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==map.get(arr[i])){
                lucky=Math.max(lucky,arr[i]);
            }
        }return lucky;
    }
}