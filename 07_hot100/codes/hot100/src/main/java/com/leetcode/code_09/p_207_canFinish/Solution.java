package com.leetcode.code_09.p_207_canFinish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * 拓扑排序 (基于 BFS) 解法
     *
     * 算法思路：
     * 这个问题可以被模型化为一个图论问题。每门课程是一个节点，先修课程关系 `[a, b]`（学 a 必须先学 b）
     * 可以看作是从节点 b 到节点 a 的一条有向边。
     * “能否完成所有课程的学习”就等价于“这个有向图中是否存在环”。如果存在环（例如 A -> B -> A），
     * 那么就无法完成学习。如果图是无环的（有向无环图，DAG），就一定可以完成。
     *
     * 拓扑排序是检测有向无环图的经典算法。这里我们使用基于广度优先搜索（BFS）的实现：
     *
     * 1. **构建图和入度数组**:
     *    - `adjacencyList`: 一个邻接表，`adjacencyList.get(i)` 存储所有以课程 `i` 为先修课的课程列表。
     *    - `inDegree`: 一个数组，`inDegree[i]` 存储指向课程 `i` 的边的数量（即课程 `i` 的先修课数量）。
     *
     * 2. **初始化队列**:
     *    - 找到所有入度为 0 的节点（即没有任何先修课的课程），并将它们加入一个队列 `queue` 中。
     *    - 这些课程是我们学习的起点。
     *
     * 3. **BFS 过程**:
     *    - 当队列不为空时，出队一个节点 `course`。
     *    - 我们将这个 `course` 视为已经学完，并将其计入已完成课程数 `coursesTaken`。
     *    - 遍历 `course` 的所有邻接节点（即所有以 `course` 为先修课的后续课程 `nextCourse`）。
     *    - 对于每一个 `nextCourse`，将其入度减 1。
     *    - 如果 `nextCourse` 的入度变为 0，说明它的所有先修课都已学完，现在可以学习它了。将其加入队列。
     *
     * 4. **判断结果**:
     *    - 循环结束后，我们检查已完成的课程数 `coursesTaken` 是否等于总课程数 `numCourses`。
     *    - 如果相等，说明所有课程都进入了拓扑排序序列，图中无环，可以完成学习。
     *    - 如果不相等，说明图中存在环，导致一些节点的入度永远无法变为 0，无法完成学习。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 构建邻接表和入度数组
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adjacencyList.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // 2. 初始化队列，加入所有入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        // 3. BFS 过程
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;

            for (int nextCourse : adjacencyList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 4. 判断结果
        return coursesTaken == numCourses;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        boolean result1 = solution.canFinish(numCourses1, prerequisites1);
        System.out.println("示例 1:");
        System.out.println("输入: numCourses = " + numCourses1 + ", prerequisites = [[1,0]]");
        System.out.println("输出: " + result1); // 应输出 true

        // 示例 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        boolean result2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println("\n示例 2:");
        System.out.println("输入: numCourses = " + numCourses2 + ", prerequisites = [[1,0], [0,1]]");
        System.out.println("输出: " + result2); // 应输出 false
    }
}
