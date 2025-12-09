class FreqStack {
    List<Stack<Integer>> list;
    Map<Integer,Integer> map=new HashMap<>();
    int maxf=0;
    public FreqStack() {
        list=new ArrayList<>();
    }
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        if(list.size()>=map.get(val)){
            list.get(map.get(val)-1).push(val);
        }else{
            Stack<Integer> st=new Stack<>();
            st.push(val);
            list.add(st);
        }
        maxf=Math.max(maxf,map.get(val));
    }
    
    public int pop() {
        int v=list.get(maxf-1).pop();
        map.put(v,map.get(v)-1);
        if((list.get(maxf-1).isEmpty())) maxf--;
        return v;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */