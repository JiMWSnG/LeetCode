package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2018/4/10  下午7:21
 */
public class GasStation {
    /**
     *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     *
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
     *
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     *
     * Note:
     * The solution is guaranteed to be unique.
     */

    /***********
     ** right **
     ***********/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int[] add = new int[N];
        // 增量
        int total = 0;
        for (int i = 0; i < N; i++){
            add[i] = gas[i] - cost[i];
            total += add[i];
        }
        if (total < 0){
            return -1;
        }
        int start = 0;
        int i = 0;
        int gasLeft = 0;
        while (i < N){
            gasLeft += add[(start + i) % N];
            if (gasLeft < 0){
                gasLeft = 0;
                start = selfIncrement(start + i, N);
                i = 0;
            }else{
                i++;
            }
        }
        return start;
    }

    private int selfIncrement(int i ,int N){
        return (i + 1) % N;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

    }
}
