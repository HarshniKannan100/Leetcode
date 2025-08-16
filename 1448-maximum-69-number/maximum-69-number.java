class Solution {
    public int maximum69Number (int num) {
        int n=num;
        int len=0;
        while(n>0){
            len++;
            n/=10;
        }
        int m=1;
        for(int i=0;i<len;i++){
            m*=10;
        }
        m/=10;
        int[] arr=new int[len+1];
        while(num>0){
            arr[len--]=num%10;
            num/=10;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=9){
                arr[i]=9;
                break;
            }
        }
        int res=0;
        for(int i=1;i<arr.length;i++){
            res+=arr[i]*m;
            m/=10;
        }
        return res;
    }
}