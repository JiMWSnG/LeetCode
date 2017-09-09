package javaSrc.Toutiao;

import java.util.*;

/**
 * @author Jim Wang
 * @create 2017-08-22 19:26
 **/
public class getRightUpPoint {
    /**
     * 第1题
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 65536KB；其他语言 589824KB
     * 题目描述：
     * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
     * 如下图：实心点为满足条件的点的集合。
     * <p>
     * 请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
     * 输入
     * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
     * 输出
     * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
     * <p>
     * 样例输入
     * 5
     * 1 2
     * 5 3
     * 4 6
     * 7 5
     * 9 0
     * 样例输出
     * 输出结果按照 x 轴排序，如上例输出为：
     * 4 6
     * 7 5
     * 9 0
     * <p>
     * Hint
     * 对于 50%的数据,  1 <= n <= 10000;
     * 对于 100%的数据, 1 <= n <= 500000;
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int xs[] = new int[N];
        Map<Integer, Integer> xy = new HashMap<>();
        for (int i = 0; i < N; i++) {
            xs[i] = sc.nextInt();
            int y = sc.nextInt();
            xy.put(xs[i], y);
        }
        Arrays.sort(xs);
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int j = N - 1; j >= 0; j--) {
            int x = xs[j];
            int y =xy.get(x);
            if ( y > max) {
                max = y;
                result.add(x);
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            int x = result.get(i);
            System.out.print(x);
            System.out.print(" ");
            System.out.println(xy.get(x));
        }


    }
}
