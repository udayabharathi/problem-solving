func findComplement(num int) int {
    mask := 1;
    for num > mask {
        mask = (mask << 1) | 1;
    }
	return num ^ mask;
}