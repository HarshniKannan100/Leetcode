class Node{
    String str;
    int f;
    public Node(String str,int f){
        this.str=str;
        this.f=f;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q=new LinkedList<>();
        int min=Integer.MAX_VALUE;
        q.add(new Node(beginWord,1));
        Set<String> seen=new HashSet<>();
        Set<String> wordSet=new HashSet<>();
        for(String s:wordList) wordSet.add(s);
        while(!q.isEmpty()){
            Node nn=q.poll();
            String s=nn.str;
            seen.add(s);
            for(int i=0;i<s.length();i++){
                for(char c='a';c<='z';c++){
                    String toS=""; 
                    if(i==0){
                        toS=c+s.substring(1);
                    }else if(i==s.length()-1){
                        toS=s.substring(0,s.length()-1)+c;
                    }else{
                        toS=s.substring(0,i)+c+s.substring(i+1);
                    }
                    if(wordSet.contains(toS) && !seen.contains(toS)){
                        if(endWord.equals(toS)){
                            min=Math.min(min,nn.f+1);
                        }else{
                            q.add(new Node(toS,nn.f+1));
                        }
                        seen.add(toS);
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}