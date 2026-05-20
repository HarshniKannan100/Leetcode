class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq1=new int[A.length+1];
        int[] freq2=new int[A.length+1];
        int fc=0;
        int[] pre=new int[A.length];
        for(int i=0;i<A.length;i++){
            freq1[A[i]]++;
            freq2[B[i]]++;
            if(freq1[A[i]]==freq2[A[i]]) fc++;
            if(A[i]!=B[i] && freq1[B[i]]==freq2[B[i]]) fc++;
            pre[i]=fc;
        }
        return pre;
    }
}