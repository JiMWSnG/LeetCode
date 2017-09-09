import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-09-08 20:32
 **/
public class miyunsuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = getNum(n);
        System.out.println(count);
    }

    static Map<Integer, Integer> map = new HashMap<>();


    public static int getNum(int n) {
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        int result = getNum(n - 1);
        for (int i = 1; i <= n; i++) {

            int temp1 = (int) Math.pow(n, i);

            int num = 0;
            if (map.containsKey(temp1)) {
                num = map.get(temp1) * 3 + 1;
                result += map.get(temp1)*2  + 1;

            } else {
                num = 1;
                result+=1;
            }
            map.put(temp1, num);
            if (i !=n){
                int temp2 = (int) Math.pow(i, n);
                if (map.containsKey(temp2)) {
                    num = map.get(temp2) * 3 + 1;
                    result += map.get(temp2)+2  + 1;

                } else {
                    num = 1;
                    result+=1;
                }

                map.put(temp2, num);
            }


        }
        return result;
    }
}
