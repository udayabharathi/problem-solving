func maxProfit(prices []int) (high int) {
    low := 100001
    for _, price := range prices {
        low = min(price, low)
        high = max(price-low, high)
    }
    return
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
