class Solution {
    
    List<Integer> l;
    
    public void helper(int num, int low, int high) {
        if(num>high) return;
        int lastDigit = num%10;
        if(lastDigit==9) return;
        int next = num*10 + (lastDigit+1);
        if(low<=next && next<=high) l.add(next);
        helper(next, low, high);
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        l=new ArrayList<Integer>();
        for(int i=1; i<10; i++)
            helper(i, low, high);
        Collections.sort(l);
        return l;
    }

}