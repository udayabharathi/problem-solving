class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int temp = n;
        int other = 0;
        while (temp > 0) {
            temp >>= 1;
            other = (other << 1) + 1;
        }
        return other ^ n;
    }
}