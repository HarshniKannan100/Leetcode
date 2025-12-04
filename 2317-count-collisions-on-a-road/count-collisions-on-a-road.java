class Solution {
    public int countCollisions(String directions) {
        int col=0;
        Stack<Character> st=new Stack<>();
        for(char ch:directions.toCharArray()){
            if(st.isEmpty()) st.push(ch);
            else if(ch=='L'){
                if(st.peek()=='R'){
                    st.pop();
                    col+=2;
                    while(!st.isEmpty() && st.peek()=='R'){
                        st.pop();
                        col++;
                    }
                    st.push('S');
                }
                else if(st.peek()=='S'){
                col++;
               }
            }else if(ch=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    col++;
                }
                st.push(ch);
            }else st.push('R');
        }
        return col;
    }
}