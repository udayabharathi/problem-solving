class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Solution::customEucledianComparator);
        for (int[] point : points) {
            pq.offer(point);
        }
        List<int[]> result = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            result.add(pq.poll());
        }
        int[][] res = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    
    private static int customEucledianComparator(int[] a, int[] b) {
        double aToCenter = Math.sqrt(a[0]*a[0] + a[1]*a[1]);
        double bToCenter = Math.sqrt(b[0]*b[0] + b[1]*b[1]);
        return Double.compare(aToCenter, bToCenter);
    }
}