class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer,List<Integer>> row=new HashMap<>();
        Map<Integer,List<Integer>> col=new HashMap<>();
        boolean flag=false;
        for(int[] n:obstacles){
            if(n[0]==0 && n[1]==0){
                flag=true;
            }
            row.putIfAbsent(n[0],new ArrayList<>());
            col.putIfAbsent(n[1],new ArrayList<>());
            row.get(n[0]).add(n[1]);
            col.get(n[1]).add(n[0]);
        }
        Map<String,Character> map=new HashMap<>();
        map.put("N-1",'E');
        map.put("N-2",'W');
        map.put("E-1",'S');
        map.put("E-2",'N');
        map.put("S-1",'W');
        map.put("S-2",'E');
        map.put("W-1",'N');
        map.put("W-2",'S');
        char cur='N';
        int x=0,y=0,max=0;
        int[] prev=new int[2];
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1 || commands[i]==-2){
                cur=map.get(cur+"-"+(-1*commands[i]));
            }else{
                boolean done=false;
                if((cur=='N' || cur=='S') && row.containsKey(x)){
                    for(int v:row.get(x)){
                        if(cur=='N' && y+commands[i]>=v && y<v){
                            y=v-1;
                            done=true;
                            break;
                        }else if(cur=='S' && y-commands[i]<=v && y>v){
                            y=v+1;
                            done=true;
                            break;
                        }
                    }
                }else if((cur=='E' || cur=='W') && col.containsKey(y)){
                    for(int v:col.get(y)){
                        if(cur=='E' && x+commands[i]>=v && x<v){
                            x=v-1;
                            done=true;
                            break;
                        }else if(cur=='W' && x-commands[i]<=v && x>v){
                            x=v+1;
                            done=true;
                            break;
                        }
                    }
                }
                if(!done){
                    if(cur=='N') y+=commands[i];
                    else if(cur=='S') y-=commands[i];
                    else if(cur=='E') x+=commands[i];
                    else x-=commands[i];
                }
                if(flag && (x==0 && y==0)){
                    x=prev[0];
                    y=prev[1];
                }
                prev[0]=x;
                prev[1]=y;
                max=Math.max(max,(x*x)+(y*y));
            }
        }
        System.out.print(x+" "+y);
        return max;
    }
}