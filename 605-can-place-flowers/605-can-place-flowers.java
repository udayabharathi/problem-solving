class Solution {
    
    private int[] bed;
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        bed = flowerbed;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (canPlace(i)) {
                count++;
                flowerbed[i] = 1;
                if (count == n)
                    return true;
            }
        }
        return count >= n;
    }

    private boolean canPlace(int index) {
        if (bed[index] != 0)
            return false;
        if (index == 0 && index + 1 < bed.length) {
            return bed[index + 1] == 0;
        } else if (index == bed.length - 1 && index - 1 >= 0) {
            return bed[index - 1] == 0;
        } else if (index != 0 && index != bed.length - 1) {
            return bed[index + 1] == 0 && bed[index - 1] == 0;
        }
        return true;
    }
}