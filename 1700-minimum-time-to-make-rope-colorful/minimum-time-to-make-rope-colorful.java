class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Character> st=new Stack<>();
        st.push(colors.charAt(0));
        int res=0;
        int prevIdx=0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==st.peek()){
                if(neededTime[i]>neededTime[prevIdx]){
                    st.pop();
                    st.push(colors.charAt(i));
                    res+=neededTime[prevIdx];
                    prevIdx=i;
                }else{
                    res+=neededTime[i];
                }
            }else{
                st.push(colors.charAt(i));
                prevIdx=i;
            }
        }
        return res;
    }
}