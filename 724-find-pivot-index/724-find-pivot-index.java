class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length-1;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[n] = nums[n];
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1]+nums[i];
            suffix[n-i] = suffix[n-i+1]+nums[n-i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] == suffix[i]) {
                return i;
            }
        }
        return -1;
    }
}