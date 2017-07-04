package javaSrc;

/**
 * Created by Jim Wang on 2017/3/15.
 */
public class Search {
    /**
     *
     * @param r
     * @param n 目标
     * @param low  前索引
     * @param high 后索引
     * @return 找到返回索引i，找不到返回-1；异常返回-2
     */
    public static int BinarySearch(int[] r,int n,int low ,int high){
        if(r==null||r.length<=0||low>high||low<0||high<=0)
            return -2;
        int mid = (low+high)/2;
        while(low<=high){
            if(r[mid]==n) return r[mid];
            else if(r[mid]>n) low = mid +1;
            else if(r[mid]<n) high = mid-1;
        }
        return -1;

    }

    /**
     * 二分查找的递归形式
     * @param r
     * @param n
     * @param low
     * @param high
     * @return
     */
    public static int BinSearch(int[] r,int n,int low ,int high){
        if(r==null||r.length<=0||low>high||low<0||high<=0)
            return -2;
        int mid = (low +high)/2;
        if(r[mid]==n) return r[mid];
        else if(r[mid]>n) BinSearch(r,n,mid+1,high);
        else if(r[mid]<n) BinSearch(r,n,low,high-1);
        return -1;
    }
}
