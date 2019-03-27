package unionfind;

/**
 * @author tianbo
 * @date 2019-03-27
 */
public class FindCircleNum {

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        Solution solution = findCircleNum.new Solution();
        int[][] arr1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        int[][] arr2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        System.out.println(solution.findCircleNum(arr1));
        System.out.println(solution.findCircleNum(arr2));
    }

    // 击败100%, 使用加权quick union实现的union find算法
    class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFindHelper unionFindHelper = new UnionFindHelper(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) {
                        unionFindHelper.union(i, j);
                    }
                }
            }
            return unionFindHelper.count();
        }

        // 并查集, 三种方案: quick-find; quick-union; weighted quick-union
        class UnionFindHelper {
            private int[] id;
            private int[] size;
            private int count;

            public UnionFindHelper(int n) {
                // 初始count为n
                count = n;
                // id取值为0~n-1
                id = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int p) {
                while (p != id[p]) {
                    p = id[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int i = find(p);
                int j = find(q);
                if (i == j) {
                    return;
                }
                // p和q不连通
                count--;
                if (size[i] < size[j]) {
                    id[i] = j;
                    size[j] += size[i];
                } else {
                    id[j] = i;
                    size[i] += size[j];
                }
            }

            public int count() {
                return count;
            }
        }
    }
}
