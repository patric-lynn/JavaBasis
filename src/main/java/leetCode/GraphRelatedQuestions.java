public class Solution {
    /*
     * 课被标号为 0 到 n-1 。有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，
     * 我们用一个匹配来表示他们： [0,1] 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     * 输入: n = 2, prerequisites = [[1,0]] 
     * 输出: [0,1]
     * 
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        // 建图
        for (int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        int numChoose = 0;
        Queue queue = new LinkedList();
        int[] topoOrder = new int[numCourses];
        
        // 将入度为 0 的编号加入队列
        for(int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (! queue.isEmpty()) {
            int nowPos = (int)queue.poll();
            topoOrder[numChoose] = nowPos;
            numChoose++;
            // 将每条边删去，如果入度降为 0，再加入队列
            for (int i = 0; i < graph[nowPos].size(); i++) {
                int nextPos = (int)graph[nowPos].get(i);
                inDegree[nextPos]--;
                if (inDegree[nextPos] == 0) {
                    queue.add(nextPos);
                }
            }
        }
        
        if (numChoose == numCourses)
            return topoOrder;
        return new int[0];
    }
}