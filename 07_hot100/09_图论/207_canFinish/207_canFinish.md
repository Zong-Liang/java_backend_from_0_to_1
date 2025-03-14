# [207_课程表](https://leetcode.cn/problems/course-schedule/)

难度：中等

## 问题描述：

你这个学期必须选修 `numCourses` 门课程，记为 `0` 到 `numCourses - 1` 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 `prerequisites` 给出，其中 `prerequisites[i] = [ai, bi]` ，表示如果要学习课程 `ai` 则 **必须** 先学习课程 `bi` 。

- 例如，先修课程对 `[0, 1]` 表示：想要学习课程 `0` ，你需要先完成课程 `1` 。

请你判断是否可能完成所有课程的学习？如果可以，返回 `true` ；否则，返回 `false` 。

**示例 1：**

```java
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
```

**示例 2：**

```java
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
```

 **提示：**`prerequisites[i]` 中的所有课程对 **互不相同**

## 解题思路：



## Java代码：

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表表示图
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        
        // 填充邻接表
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        // 0 = 未访问，1 = 正在访问，2 = 已完成访问
        int[] visited = new int[numCourses];
        
        // 对每个课程进行DFS
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(adjacency, visited, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(List<List<Integer>> adjacency, int[] visited, int course) {
        // 标记为正在访问
        visited[course] = 1;
        
        // 检查所有先修课程
        for (int prerequisite : adjacency.get(course)) {
            // 如果先修课程未访问，则继续DFS
            if (visited[prerequisite] == 0) {
                if (!dfs(adjacency, visited, prerequisite)) {
                    return false;
                }
            }
            // 如果先修课程正在访问中，说明存在环
            else if (visited[prerequisite] == 1) {
                return false;
            }
            // 如果先修课程已完成访问，继续检查下一个
        }
        
        // 标记为已完成访问
        visited[course] = 2;
        return true;
    }
}

// 测试代码
public class CourseScheduleTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 测试用例1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("测试用例1结果: " + solution.canFinish(numCourses1, prerequisites1));
        
        // 测试用例2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("测试用例2结果: " + solution.canFinish(numCourses2, prerequisites2));
    }
}
```

