class Trie{
    Trie[] arr=new Trie[26];
    int bestLen=Integer.MAX_VALUE;
    int bestIdx=Integer.MAX_VALUE;
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie obj=new Trie();
        for(int i=0;i<wordsContainer.length;i++){
            String s=wordsContainer[i];
            int len=s.length();
            Trie cur=obj;
            if(len<cur.bestLen || (len==cur.bestLen && i<cur.bestIdx)){
                cur.bestLen=len;
                cur.bestIdx=i;
            }
            for(int j=len-1;j>=0;j--){
                int idx=s.charAt(j)-'a';
                if(cur.arr[idx]==null){
                    cur.arr[idx]=new Trie();
                }
                cur=cur.arr[idx];
                if(len<cur.bestLen || (len==cur.bestLen && i<cur.bestIdx)){
                    cur.bestLen=len;
                    cur.bestIdx=i;
                }
            }
        }
        int[] ans=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            String q=wordsQuery[i];
            int len=q.length();
            Trie cur=obj;
            for(int j=len-1;j>=0;j--){
                int idx=q.charAt(j)-'a';
                if(cur.arr[idx]==null){
                    break;
                }
                cur=cur.arr[idx];
            }
            ans[i]=cur.bestIdx;
        }
        return ans;
    }
}