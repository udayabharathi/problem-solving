class Solution {
    
    private int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        // dp = new int[text1.length()][text2.length()];
        // for (int[] i : dp)
        //     Arrays.fill(i, -1);
        // return helper(text1, text2, text1.length()-1, text2.length()-1);
        return helper2(text1, text2);
    }
    
    private int helper(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + helper(text1, text2, i-1, j-1);
        } else {
            return dp[i][j] = Math.max(helper(text1, text2, i-1, j), helper(text1, text2, i, j-1));
        }
    }
    
    private int helper2(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

// O(2 ^ max(text1.length(), text2.length()))
// O()