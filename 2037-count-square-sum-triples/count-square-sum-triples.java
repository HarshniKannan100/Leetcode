class Solution {
    public int countTriples(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i*i);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(list.contains(list.get(i)+list.get(j))) count+=2;
            }
        }
        return count;
    }
}