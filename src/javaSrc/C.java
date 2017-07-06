package javaSrc;


import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/6.
 */
public class C {
    private int M;                   //行
    private int N;                   //列
    private double[] s;              //输入概率分布
    private double[][] P;            //转移概率矩阵
    private double[][] Q;            //
    private double C;                //信道容量
    private double det;              //迭代精度
    public C(int m, int n, double[] s, double[][] p) {
        M = m;
        N = n;
        this.s = s;
        P = p;
        det = 0.0001;

    }

    public double getC() {
        return C;

    }

    public void setC(double c) {
        C = c;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public double[] getS() {
        return s;
    }

    public void setS(double[] s) {
        this.s = s;
    }

    public double[][] getP() {
        return P;
    }

    public void setP(double[][] p) {
        P = p;
    }

    public double[][] getQ() {
        return Q;
    }

    public void setQ(double[][] q) {
        Q = q;
    }
    
   
    /**
     * 计算Q矩阵
     * @author Jim Wang
     * @return  
     */
    public double[][]  caculateQ(){
        double[][] Q_temp = new double[N][M];
        for (int j = 0; j < N; j++) {
            double sum = 0;
            for (int i = 0; i < M; i++) {
                sum = sum + s[i] * P[i][j];
            }
            for (int i = 0; i < M; i++)
                Q_temp[j][i] = (s[i] * P[i][j]) / sum;
        }
        Q = Q_temp;
        return Q_temp;
    }
    /**
     * 计算pi的分母
     * @author Jim Wang
     * @return 第k次计算pi的分母
     */
    public double caculateS_fenmu(){
        // 计算分母
        double sum1 = 0;//保存分母的值
        for (int i = 0; i < M; i++) {    //对行求和
            boolean flag3 = true;
            double sum2 = 0;
            for (int j = 0; j < N; j++) {//对列求和
                if (Q[j][i] != 0)
                    sum2 = sum2
                            + (P[i][j] * (Math.log(Q[j][i]) / Math  //将log（）变为ln（）
                            .log(Math.E)));
                else if (Q[j][i] == 0 && P[i][j] != 0) {
                    flag3 = false;
                }// exp(log0)=0,下同
                else if (Q[j][i] == 0 && P[i][j] == 0)
                    sum2 = sum2 + 0;// 0log0=0
            }

            if (flag3)
                sum1 = sum1 + Math.exp(sum2);
            else
                sum1 = sum1 + 0;
        }
        return sum1;
    }
    
    /**
     * 计算第k次输入概率分布
     * @author Jim Wang
     * @param fenmu
     * @return
     */
    public double[] caculateS(double fenmu) {
        /** 计算SS[i] */

        double[] SS = new double[M];
        for (int i = 0; i < M; i++) {
            boolean flag1 = true;// 若有无穷比无穷
            double sum6 = 0;
            for (int j = 0; j < N; j++) {
                if (Q[j][i] != 0)
                    sum6 = sum6 + P[i][j]
                            * (Math.log(Q[j][i]) / Math.log(Math.E));
                else if (Q[j][i] == 0 && P[i][j] != 0) {
                    flag1 = false;
                } else if (Q[j][i] == 0 && P[i][j] == 0)
                    sum6 = sum6 + 0;
            }
            if (flag1)
                SS[i] = Math.exp(sum6) / fenmu;   //无穷比无穷的情况
            else
                SS[i] = 0;
        }
        return SS;
    }

    public double getDet() {
        return det;
    }

    public void setDet(double det) {
        this.det = det;
    }

    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("输入状态转移矩阵的行列数M，N：");
            int NUM = 0;
            int M = input.nextInt();
            int N = input.nextInt();
             System.out.println("设置迭代精度det：");
            double det_init = input.nextDouble();

            double[][] p = new double[M][N];
            System.out.println("输入状态转移矩阵：");
            /** 输入转移矩阵 */
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++) {
                    p[i][j] = input.nextDouble();
                }
            /** 初始化数据 */
            double s[]= new double[M];
            for (int i = 0; i < M; i++)
               s[i] = (double) 1 / M;// 赋值，输入概率分布初始化为均匀分布
            C c= new C (M, N, s, p);
            c.setDet(det_init);

            /**开始迭代 */
            Boolean flag = true;
            while(flag){
                c.caculateQ();
                double fenmu = c.caculateS_fenmu();
                double SS[] = c.caculateS(fenmu);
                double det = 0;
             for (int i = 0; i <M; i++) {
                    det = det + Math.pow(SS[i] - c.getS()[i], 2);// 计算范数
                }
                if (det < c.getDet())       //判断是否满足迭代精度
                    flag = false;
                else {
                   c.setS(SS);
                }
                c.setC( Math.log(fenmu) / Math.log(2));//log以2为底
                NUM++;
            }


            /**输出结果*/
            System.out.println("经过" + NUM + "次迭代计算得到结果如下：");
            System.out.print("其最佳信源分布为：(");
            for (int i = 0; i < M - 1; i++)
                System.out.print(c.getS()[i] + ",");
            System.out.print(c.getS()[M - 1]);
            System.out.println(")");
            System.out.println("其信道容量为：" + c.getC());
    }




}