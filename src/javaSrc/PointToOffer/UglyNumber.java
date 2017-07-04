package javaSrc.PointToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim Wang on 2017/5/24.
 */
public class UglyNumber {
    /**
     * 丑数
     * 题目描述
     把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
     习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
     */
    public int GetUglyNumber_Solution(int index) {
        if(index<1){
            return 0;
        }
        List<Integer> uglyNum = new ArrayList<>();
        uglyNum.add(1);
        int foundUgly = 1;
        int number = 1;
        int threadOf2 =0;
        int threadOf3 =0;
        int threadOf5 =0;
        int tmp2,tmp3,tmp5;
        while(foundUgly<index){
            while(uglyNum.get(threadOf2)*2<=number){
                if(threadOf2<uglyNum.size())
                    threadOf2 ++;
            }
            tmp2 = uglyNum.get(threadOf2)*2;
            while(uglyNum.get(threadOf3)*3<=number){
                if(threadOf3<uglyNum.size())
                    threadOf3 ++;
            }
            tmp3 = uglyNum.get(threadOf3)*3;
            while(uglyNum.get(threadOf5)*5<=number){
                if(threadOf5<uglyNum.size())
                    threadOf5 ++;
            }
            tmp5 = uglyNum.get(threadOf5)*5;
            number = min(tmp2,tmp3,tmp5);
            uglyNum.add(number);
            foundUgly++;
        }





        return number;
    }
    private int min(int a ,int b ,int c){
        int tmp = Math.min(a,b);
        return Math.min(tmp,c);
    }


}
