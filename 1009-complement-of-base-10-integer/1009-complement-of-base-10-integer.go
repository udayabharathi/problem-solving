func bitwiseComplement(n int) int {
    if n == 0 {
        return 1
    }
    t := n
    o := 0
    for t > 0 {
        t >>= 1
        o = (o << 1) + 1
    }
    return o ^ n
}