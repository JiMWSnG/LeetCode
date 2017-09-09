package javaSrc;

import java.util.Scanner;

/**
 * @author Jim Wang
 * @create 2017-08-19 19:58
 **/
public class query {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int maxId = 0;
        for (int i = 0; i < n; i++) {
            array[i] = maxId + sc.nextInt();
            maxId = array[i];
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int id = sc.nextInt();
            int result = halfSerach(array, id, 0, n - 1) + 1;
            System.out.println(result);
        }


    }

    public static int halfSerach(int[] array, int id, int start, int end) {
        int mid = start + end;
        if (mid == 0) {
            if (id <= array[mid]) {
                return mid;
            }
            return -1;
        }
        if (id <= array[mid] && id > array[mid - 1]) {
            return mid;
        } else if (id > array[mid]) {
            return halfSerach(array, id, mid + 1, end);
        } else if (id < array[mid] && id <= array[mid - 1]) {
            return halfSerach(array, id, start, mid - 1);
        }
        return -1;

    }

}
