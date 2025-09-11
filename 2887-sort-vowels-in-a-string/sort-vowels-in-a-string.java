class Solution {
    public String sortVowels(String s) {
  
        int[] asci=new int[128];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' ||ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                asci[(int)ch]++;
            }
        }
        List<Character> list=new ArrayList<>();
        for(int i=65;i<128;i++){
            if(asci[i]!=0){
                for(int j=0;j<asci[i];j++){
                    list.add((char)i);
                }
            }
        }
    int p=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' || ch=='a' ||ch=='e' || ch=='i' ||ch=='o' ||ch=='u'){
                sb.append(list.get(p++));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}