class Solution {
    public int findMax(int[][] t) {
        int max = Integer.MIN_VALUE;
        for(int[] i: t) {
            max = Math.max(max, i[2]);
        }
        return max;
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        int maxTrip = findMax(trips);
        int[][] dp = new int[maxTrip+1][2];
        for(int[] i: trips) {
            dp[i[1]][0]+=i[0];
            dp[i[2]][1]+=i[0];
        }
        int currCapacity=capacity;
        for(int[] i: dp) {
            currCapacity+=i[1];
            if(currCapacity<i[0]) return false;
            currCapacity-=i[0];
        }
        return true;
    }
}