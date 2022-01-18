func sortedSquares(nums []int) (result []int) {
    index1 := 0
    for i, val := range nums {
        if val >= 0 {
            break
        } else {
            index1 = i
        }
    }
    index2 := index1 + 1
    for len(result) < len(nums) {
        if index1 >= 0 && index2 < len(nums) {
            val1 := nums[index1] * nums[index1]
            val2 := nums[index2] * nums[index2]
            if val1 < val2 {
                result = append(result, val1)
                index1--
            } else {
                result = append(result, val2)
                index2++
            }
        } else if index1 >= 0 {
            val := nums[index1] * nums[index1]
            result = append(result, val)
            index1--
        } else if index2 < len(nums) {
            val := nums[index2] * nums[index2]
            result = append(result, val)
            index2++
        }
    }
    return
}