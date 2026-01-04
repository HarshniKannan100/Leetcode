class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int N=nums.length;
        List<Long> oddnums=new ArrayList<>();
        List<Long> evennums=new ArrayList<>();
        List<Long> oddtarget=new ArrayList<>();
        List<Long> eventarget=new ArrayList<>();
        for(long n:nums){
            if(n%2==0) evennums.add(n);
            else oddnums.add(n);
        }
        for(long n:target){
            if(n%2==0) eventarget.add(n);
            else oddtarget.add(n);
        }
        Collections.sort(evennums);
        Collections.sort(eventarget);
        Collections.sort(oddnums);
        Collections.sort(oddtarget);
        long diff=0;
        for(int i=0;i<oddnums.size();i++){
            diff+=Math.abs(oddnums.get(i)-oddtarget.get(i));
        }
        for(int i=0;i<evennums.size();i++){
            diff+=Math.abs(evennums.get(i)-eventarget.get(i));
        }
        return diff/4;
    }
}