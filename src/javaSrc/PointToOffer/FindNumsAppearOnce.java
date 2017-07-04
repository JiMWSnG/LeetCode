package javaSrc.PointToOffer;

/**
 * Created by Jim Wang on 2017/6/3.
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
       int [] a  ={2,4,3,6,3,2,5,5};
       int[] a1 ={0};
       int[] a2 ={0};
       new FindNumsAppearOnce().FindNumsAppearOnce(a ,a1,a2);
        System.out.println(a1[0]);
        System.out.println(a2[0]);
    }
    /**
     *数组中只出现一次的数字
     *
     * 题目描述
     一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     请写程序找出这两个只出现一次的数字。
     */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int once = findNumOnce(array);
        int i =0;
        while((once&1)==0){
            once = once>>1;
            i++;
        }
        num1[0]=0;
        num2[0]=0;
        for(int j = 0;j<array.length;j++){
            if((array[j]>>i&1)==1)
                num1[0] ^=array[j];
            else
                num2[0] ^=array[j];
        }

    }
    private int findNumOnce(int[] array){
        if(array==null)
            return -1;
        int result=0;
        int len = array.length;
        for(int i =0;i<len;i++){
            result=result^array[i];
        }
        return result;
    }

}
