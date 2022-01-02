class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int i : time) {
            count[i%60]++;
        }
        int l = 1;
        int h = 59;
        int result = 0;
        while (l < h) {
            result += (count[l++] * count[h--]);
        }
        result += (count[0] * (count[0]-1))/2;
        result += (count[30] * (count[30]-1))/2;
        return result;
    }
}