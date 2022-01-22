class Solution {
    Map<Integer, Boolean> dp;
    
    public boolean winnerSquareGame(int n) {
        dp = new HashMap<>();
        dp.put(0, false);
        return isWinner(n);
    }
    
    private boolean isWinner(int n) {
        if(dp.containsKey(n)) return dp.get(n);
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(!isWinner(n-(i*i))) {
                dp.put(n, true);
                return true;
            }
        }
        dp.put(n, false);
        return false;
    }
}