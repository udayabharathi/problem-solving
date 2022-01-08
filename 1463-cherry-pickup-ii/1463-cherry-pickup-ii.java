class Solution {

    Integer[][][] dp;
    int[][] g;

    public int cherryPickup(int[][] grid) {
        g = grid;
        dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return dfs(0, 0, grid[0].length - 1);
    }

    private int dfs(int i, int j, int k) {
        if (j < 0 || j >= g[0].length || k < 0 || k >= g[0].length)
            return 0;
        if (dp[i][j][k] != null)
            return dp[i][j][k];
        int result = 0;
        result += g[i][j];
        if (j != k)
            result += g[i][k];
        if (i == g.length - 1)
            return dp[i][j][k] = result;
        int max = 0;
        for (int a = j - 1; a <= j + 1; a++) {
            for (int b = k - 1; b <= k + 1; b++) {
                max = Math.max(max, dfs(i + 1, a, b));
            }
        }
        return dp[i][j][k] = result + max;
    }
}