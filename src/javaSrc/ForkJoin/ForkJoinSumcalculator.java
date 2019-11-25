package javaSrc.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author jimwong
 * @since 2018/6/15
 */
public class ForkJoinSumcalculator extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 12500000;

    public ForkJoinSumcalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumcalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumcalculator leftTask = new ForkJoinSumcalculator(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumcalculator rightTask = new ForkJoinSumcalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] num = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumcalculator(num);
        return new ForkJoinPool().invoke(task);
    }

    public static long sum(long n) {
        long[] num = LongStream.rangeClosed(1, n).toArray();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }
        return sum;

    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long n = forkJoinSum(100000000);
        long end = System.currentTimeMillis();
        System.out.println(n);
        System.out.println(end - start);

        start = System.currentTimeMillis();
        n = sum(100000000);
        end = System.currentTimeMillis();
        System.out.println(n);
        System.out.println(end - start);
    }
}
