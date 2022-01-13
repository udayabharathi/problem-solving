class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] prev = points[0];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            // System.out.println(Arrays.toString(prev));
            if (prev[1] < points[i][0]) {
                
                count++;
                prev = points[i];
                continue;
            }
            prev[0] = Math.max(prev[0], points[i][0]);
            prev[1] = Math.min(prev[1], points[i][1]);
        }
        return count;
    }
}