/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var result int

func maxAncestorDiff(root *TreeNode) int {
    result = 0
    helper(root, root.Val, root.Val)
    return result
}

func helper(root *TreeNode, currMax, currMin int) {
    if root == nil {
        return
    }
    result = max(result, max(abs(currMax - root.Val), abs(currMin - root.Val)))
    helper(root.Left, max(currMax, root.Val), min(currMin, root.Val))
    helper(root.Right, max(currMax, root.Val), min(currMin, root.Val))
}

func abs(a int) int {
    if a < 0 {
        return a * -1
    }
    return a
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}