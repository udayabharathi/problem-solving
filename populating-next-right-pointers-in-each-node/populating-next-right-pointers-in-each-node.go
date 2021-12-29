/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
    if root == nil {
        return root
    }
    queue := NewQueue()
    queue.Offer(root)
    for !queue.IsEmpty() {
        var prev *Node
        size := queue.Size()
        for size > 0 {
            size--
            curr := queue.Poll()
            if curr.Left != nil && curr.Right != nil {
                queue.Offer(curr.Left)
                queue.Offer(curr.Right)
            }
            if prev != nil {
                prev.Next = curr
            }
            prev = curr
        }
    }
    return root
}

type ListNode struct {
    val *Node
    next *ListNode
}

type Queue struct {
    start *ListNode
    end *ListNode
    size int
}

func NewQueue() *Queue {
    return &Queue{}
}

func (q *Queue) Print() {
    head := q.start
    fmt.Print("[")
    for head != nil {
        fmt.Print(head.val, ",")
        head = head.next
    }
    fmt.Println("]")
}

func (q *Queue) Offer(val *Node) {
    if q.start == nil {
        q.start = &ListNode{val, nil}
    }
    if q.end == nil {
        q.end = q.start
    } else {
        q.end.next = &ListNode{val, nil}
        q.end = q.end.next
    }
    q.size++
}

func (q *Queue) Poll() *Node {
    if q.IsEmpty() {
        panic("Queue is already empty")
    }
    toReturn := q.start
    q.start = q.start.next
    if q.start == nil {
        q.end = nil
    }
    q.size--
    return toReturn.val
}

func (q *Queue) IsEmpty() bool {
    return q.start == nil
}

func (q *Queue) Size() int {
    return q.size
}
