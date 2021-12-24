func findOrder(numCourses int, prerequisites [][]int) (result []int) {
    
    graph := make([][]int, numCourses)
    indegree := make([]int, numCourses)
    for i := range graph {
        graph[i] = make([]int, 0)
    }
    
    for _, i := range prerequisites {
        graph[i[1]] = append(graph[i[1]], i[0])
        indegree[i[0]]++
    }
    
    queue := NewQueue()
    
    for i := range graph {
        if indegree[i] == 0 {
            queue.Offer(i)
        }
    }
    
    for !queue.IsEmpty() {
        size := queue.Size()
        for size > 0 {
            size--
            val := queue.Poll()
            result = append(result, val)
            for _, i := range graph[val] {
                indegree[i]--
                if indegree[i] == 0 {
                    queue.Offer(i)
                }
            }
        }
    }
    
    if len(result) != numCourses {
        return make([]int, 0)
    }
    
    return
}

type ListNode struct {
    val int
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

func (q *Queue) Offer(val int) {
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

func (q *Queue) Poll() int {
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