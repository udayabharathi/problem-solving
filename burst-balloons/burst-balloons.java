class Solution {
    private int[] nums;
    private int[][] dp;
    
    public int maxCoins(int[] nums) {
        this.nums = new int[nums.length+2];
        this.nums[0] = 1;
        this.nums[nums.length+1] = 1;
        for (int i = 0; i < nums.length; i++) {
            this.nums[i+1] = nums[i];
        }
        dp = new int[nums.length+2][nums.length+2];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return helper(1, nums.length);
    }
    
    private int helper(int l, int r) {
        if (l > r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        int result = 0;
        for (int i = l; i <= r; i++) {
            int temp = nums[l-1] * nums[i] * nums[r+1];     // i will be burst after bursting everything in range l to i-1 and i+1 to r
            result = Math.max(result, temp + helper(l, i-1) + helper(i+1, r));
        }
        return dp[l][r] = result;
    }
}