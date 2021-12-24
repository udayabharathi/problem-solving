func merge(intervals [][]int) (result [][]int) {
    sort.Sort(interval(intervals))
    
    start := intervals[0][0]
    end := intervals[0][1]
    
    for i := 1; i < len(intervals); i++ {
        if intervals[i][0] <= end {
            end = max(end, intervals[i][1])
        } else {
            result = append(result, []int{start, end})
            start = intervals[i][0]
            end = intervals[i][1]
        }
    }
    
    result = append(result, []int{start, end})
    
    return
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

type interval [][]int

func (i interval) Len() int {
    return len(i)
}

func (i interval) Swap(a, b int) {
    i[a], i[b] = i[b], i[a]
}

func (i interval) Less(a, b int) bool {
    return i[a][0] < i[b][0]
}