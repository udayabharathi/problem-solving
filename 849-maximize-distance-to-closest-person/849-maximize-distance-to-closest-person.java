class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] pre = new int[seats.length];
        int[] post = new int[seats.length];
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                pre[i] = 0;
            } else {
                pre[i] = pre[i-1] + 1;
            }
        }
        for (int i = seats.length - 2; i >= 0; i--) {
            if (seats[i] == 1) {
                post[i] = 0;
            } else {
                post[i] = post[i+1] + 1;
            }
        }
        pre[0] = Integer.MAX_VALUE;
        post[seats.length-1] = Integer.MAX_VALUE;
        // System.out.println("pre: "+Arrays.toString(pre)+", post: "+Arrays.toString(post));
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            max = Math.max(max, Math.min(pre[i], post[i]));
        }
        return max;
    }
}