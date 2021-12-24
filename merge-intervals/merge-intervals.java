class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0]-b[0]));
        int[] curr = intervals[0];
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curr[1]) {
                result.add(new int[] {curr[0], curr[1]});
                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
            } else {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        result.add(new int[] {curr[0], curr[1]});
        return result.toArray(int[][]::new);
    }
}