package javaSrc.LeetCode;

/**
 * @Author jimwong
 * @since 2018/5/8
 */
public class MedianofTwoSortedArrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * The median is 2.0
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * The median is (2 + 3)/2 = 2.5
     */

    /***********
     ** right **
     ***********/
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    /**
     * 第一种思路
     * 获取前k个数
     *
     * @param A
     * @param aStart
     * @param B
     * @param bStart
     * @param k
     * @return
     */
    private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) {
            aMid = A[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < B.length) {
            bMid = B[bStart + k / 2 - 1];
        }
        // a数组前k/2个必然是最小的k/2
        if (aMid < bMid) {
            // Check: aRight + bLeft
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            // Check: bRight + aLeft
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }


    /**
     * 第二种思路
     * left_part          |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * <p>
     * MAKE SURE
     * 1\ len(right_part) - len(left_part) = k OR len(left_part) - len(right_part) = k
     * 2\ max(left_part) <= min(right_part)  =>  A[i-1] <=B[j] && b[j-1] <= a[i]               </=>
     * TO FIND THE Kth NUMBER
     */
    /***********
     ** right **
     ***********/
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                // i is too small
                iMin = iMin + 1;
            }
            else if (i > iMin && A[i-1] > B[j]) {
                // i is too big
                iMax = iMax - 1;
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    private double findKthSortedArrays(int[] A, int[] B, int k) {
        int m = A.length;
        int n = B.length;
        if (k <= (m + n + 1) / 2) {
            k = -k;
        }
        int i = m / 2;
        // i~(0,m)
        int j = (m + n + k + 1) / 2 - i;
        while (i==1) {
            if (A[i - 1] <= B[j] && B[j - 1] <= A[i]){
                return Math.max(A[i-1],B[j-1]);
            }
            if (A[i-1]>B[j]){
                i = i/2;
            } else if (B[j-1]> A[i]) {
                i = (i+m)/2;
            }
        }
        return 0.0;

    }
}
