func findJudge(n int, trust [][]int) int {
    if len(trust) == 0 && n == 1 {
        return 1
    }
    a := make(map[int]map[int]struct{})
    b := make(map[int]map[int]struct{})
    for _, i := range trust {
        if _, ok := a[i[0]]; !ok {
            a[i[0]] = make(map[int]struct{})
        }
        a[i[0]][i[1]] = struct{}{}
        if _, ok := b[i[1]]; !ok {
            b[i[1]] = make(map[int]struct{})
        }
        b[i[1]][i[0]] = struct{}{}
    }
    
    for i:=1; i<=n; i++ {
        if _, ok := a[i]; !ok {
            if val, ok := b[i]; ok {
                if len(val) == n-1 {
                    return i
                }
            }
        }
    }
    
    return -1
}