func twoSum(nums []int, target int) []int {
    set := make(map[int]int)
    for i, n := range nums {
        if j, ok := set[target-n]; ok {
            return []int{j, i}
        }
        set[n] = i
    }
    return nil
}