package javaSrc.Alibaba;

/**
 * @author Jim Wang
 * @create 2017-08-25 20:21
 **/
import java.lang.reflect.Array;
import java.util.Scanner;
public class Main1 {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     *
     *
     * 输入范例:
     10 20 30
     3
     1000 10 10 30
     500 10 10 20
     600 8 10 20
     输出范例:
     2**/
    private static int process()
    {
    return 0;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Model boxTemplate = new Model();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println (process());

        }
    }
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    public static class Model{
        public int length;
        public int width;
        public int height;
        public int price;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

}
