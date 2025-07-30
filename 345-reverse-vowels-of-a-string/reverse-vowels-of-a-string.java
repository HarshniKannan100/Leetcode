class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st=new Stack<>();
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                sb.append(st.pop());
            }else sb.append(ch);
        }
        return sb.toString();
    }
}