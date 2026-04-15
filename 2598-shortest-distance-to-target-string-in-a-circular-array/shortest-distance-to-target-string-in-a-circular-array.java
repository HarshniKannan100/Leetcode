class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                min=Math.min(min,Math.abs(startIndex-i));
                min=Math.min(min,words.length-Math.max(i,startIndex)+Math.min(i,startIndex));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}