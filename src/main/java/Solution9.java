

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */
import java.util.ArrayList;
import java.util.List;

class Solution9 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] fa = new int[n + 1]; // 并查集，初始化为节点自身（负数表示集合的代表）
        for (int i = 1; i <= n; i++) {
            fa[i] = -1; // 初始化为-1表示每个节点各自为一个集合的代表
        }
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            int a = p[0], b = p[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            for (int neighbor : g[i]) {
                int rootI = findFa(i, fa);
                int rootNeighbor = findFa(neighbor, fa);
                if (rootI == rootNeighbor) {
                    // 如果已经在同一个集合中，则无法分组
                    return false;
                }
                // 将两个节点合并到不同的集合中，这里使用不同的符号（如正负）来区分两个分组
                if (fa[rootI] > 0) fa[rootI] = -rootNeighbor; // 将i的集合代表设置为-neighbor的集合代表（或相反）
                else if (fa[rootNeighbor] > 0) fa[rootNeighbor] = -rootI;
                // 如果两者都是负数，则不需要改变，因为它们已经是集合的代表，并且已经在不同的分组中
            }
        }
        return true;
    }

    private void union(int x, int y, int[] fa) {
        int rootX = findFa(x, fa);
        int rootY = findFa(y, fa);
        if (rootX != rootY) {
            // 合并两个集合，使用不同的符号来区分分组
            if (fa[rootX] > 0) fa[rootX] = -rootY; // 将x的集合代表设置为-y的集合代表
            else if (fa[rootY] > 0) fa[rootY] = -rootX;
            // 如果rootX和rootY都是负数，则它们已经是不同集合的代表，不需要合并
        }
    }

    private int findFa(int x, int[] fa) {
        if (fa[x] < 0) {
            // 如果是负数，则x是代表
            return x;
        }
        // 路径压缩
        fa[x] = findFa(fa[x], fa);
        return fa[x];
    }
}
