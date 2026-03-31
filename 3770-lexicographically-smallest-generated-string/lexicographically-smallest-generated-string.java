class Solution {
    public String generateString(String str1, String str2) {
        int N=str1.length(),M=str2.length();
        char[] res=new char[N+M-1];
        Arrays.fill(res,'?');
        for(int i=0;i<N;i++){
            if(str1.charAt(i)=='F'){
                continue;
            }
            for(int j=0;j<M;j++){
                char ch=res[i+j];
                if(ch!='?' && ch!=str2.charAt(j)) return "";
                res[i+j]=str2.charAt(j);
            }
        }
        char[] copy=res.clone();
        for(int i=0;i<N+M-1;i++){
            if(res[i]=='?') res[i]='a';
        }
        for(int i=0;i<N;i++){
            if(str1.charAt(i)=='T') continue;
            if(!new String(res,i,M).equals(str2)){
                continue;
            }
            boolean flag=false;
            for(int j=i+M-1;j>=i;j--){
                if(copy[j]=='?'){
                    res[j]='b';
                    flag=true;
                    break;
                }
            }
            if(!flag) return "";
        }
        return new String(res);
    }
}