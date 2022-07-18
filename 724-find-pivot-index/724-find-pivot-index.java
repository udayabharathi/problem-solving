class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int runningSum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (runningSum == sum - runningSum - nums[i]) {
                return i;
            }
            runningSum += nums[i];
        }
        return -1;
    }
}