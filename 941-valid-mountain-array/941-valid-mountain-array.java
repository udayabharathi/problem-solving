class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean isRising = true;
        boolean isFalling = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i+1] && isRising) {
                if (isFalling)
                    return false;
                continue;
            } else if (arr[i] > arr[i+1] && isRising) {
                if (i == 0)
                    return false;
                isFalling = true;
            } else if (arr[i] == arr[i+1]) {
                return false;
            }
        }
        return isRising && isFalling;
    }
}