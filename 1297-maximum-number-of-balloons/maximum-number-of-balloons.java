class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];
        for(char ch:text.toCharArray()){
            freq[ch-'a']++;
        }
        int min=Integer.MAX_VALUE;
        int b=freq[1];
        int a=freq[0];
        int l=freq[11];
        int o=freq[14];
        int n=freq[13];
        System.out.print(b+" "+a+" "+l+" "+o+" "+n);
        if(b==0 || a==0 || l<=1 || o<=1 || n==0){
            return 0;
        }
        l/=2;
        o/=2;
        min=Math.min(Math.min(b,a),Math.min(l,o));
        return Math.min(min,n);
    }
}