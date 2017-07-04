package javaSrc.PointToOffer;

/**
 * Created by Jim Wang on 2017/6/1.
 */
public class GetNumberOfK {
    /**
     *数字在排序数组中出现的次数
     *
     * 题目描述
     统计一个数字在排序数组中出现的次数。
     */
    public int GetNumberOfK(int [] array , int k) {

        if(array==null||array.length==0)
            return 0;
        int num =0;
        int len = array.length;
        int i =0;
        while(k!=array[i]){
            if(k>array[i])
                i=(i+len-1)>>1;
            else
                i=i>>1;
        }

        return num;

    }
}
