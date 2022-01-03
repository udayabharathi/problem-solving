func findJudge(n int, trust [][]int) int {
    count := make([]int, n)
    for _, t := range trust {
        count[t[0]-1]--
        count[t[1]-1]++
    }
    
    for i:=0; i<n; i++ {
        if count[i] == n-1 {
            return i+1
        }
    }
    
    return -1
}