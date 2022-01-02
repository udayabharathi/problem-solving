func numPairsDivisibleBy60(time []int) (result int) {
    count := make([]int, 60)
    for _, t := range time {
        count[t%60]++
    }
    l := 1
    h := 59
    for l < h {
        result += count[l] * count[h]
        l++
        h--
    }
    result += (count[0] * (count[0]-1))/2
    result += (count[30] * (count[30]-1))/2
    return
}