class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        int[] inorder = new int[numCourses];
        
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            inorder[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int resultIndex = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                result[resultIndex++] = curr;
                for (int next : adjacencyList.get(curr)) {
                    if (--inorder[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        if (resultIndex != numCourses) {
            return new int[0];
        }
        return result;
    }
}