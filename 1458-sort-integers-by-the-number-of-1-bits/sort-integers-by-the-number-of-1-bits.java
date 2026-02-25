class Num implements Comparable<Num>{
    int val;
    int setbits;
    public int compareTo(Num oth){
        if(this.setbits==oth.setbits){
            return this.val-oth.val;
        }
         return this.setbits-oth.setbits;
    }
}
class Solution {
    public int[] sortByBits(int[] arr) {
        List<Num> list=new ArrayList<>();
        for(int num:arr){
            Num numobj=new Num();
            numobj.val=num;
            numobj.setbits=findsetbits(num);
            list.add(numobj);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i).val;
        }
        return arr;
    }
    private int findsetbits(int num){
        int setbits=0;
        while(num!=0){
            num=num&(num-1);
            setbits++;
        }
        return setbits;
    }
}