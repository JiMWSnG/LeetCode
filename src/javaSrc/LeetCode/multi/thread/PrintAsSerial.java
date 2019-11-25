package javaSrc.LeetCode.multi.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintAsSerial {
    private CountDownLatch thirdLatch = new CountDownLatch(1);
    private CountDownLatch secondLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        PrintAsSerial printAsSerial = new PrintAsSerial();
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                printAsSerial.new Foo().one();
            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                printAsSerial.new Foo().two();
            }
        };
        Runnable run3 = new Runnable() {
            @Override
            public void run() {
                printAsSerial.new Foo().three();
            }
        };
        new Thread(run2).start();
        new Thread(run1).start();
        new Thread(run3).start();

    }

    public class Foo {
        public void one() {
            System.out.print("one");
            secondLatch.countDown();
        }

        public void two() {
            try{
                secondLatch.await();
            }catch (InterruptedException e){

            }
            System.out.print("two");
            thirdLatch.countDown();
        }

        public void three() {
            try{
                thirdLatch.await();
            }catch (InterruptedException e){

            }
            System.out.print("three");
        }
    }
}
