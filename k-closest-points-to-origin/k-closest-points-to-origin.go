type CartesianPoints [][]int

func kClosest(points [][]int, k int) (result [][]int) {
    sort.Sort(CartesianPoints(points))
    i := 0
    for k > 0 && i < len(points) {
        result = append(result, points[i])
        k--
        i++
    }
    return
}

func (c CartesianPoints) Less(a, b int) bool {
    return gapToCenter(c[a]) < gapToCenter(c[b])
}

func (c CartesianPoints) Swap(a, b int) {
    c[a], c[b] = c[b], c[a]
}

func (c CartesianPoints) Len() int {
    return len(c)
}

func gapToCenter(a []int) float64 {
    return math.Sqrt(float64(a[0]*a[0] + a[1]*a[1]))
}