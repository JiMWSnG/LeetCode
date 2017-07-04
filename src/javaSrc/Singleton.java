package javaSrc;

/**
 * Created by Jim Wang on 2017/3/7.
 */


/**
 * 饿汉式
 */
public class Singleton {
    static{ System.out.println("开始初始化静态变量"); }
    private static Singleton instance=new Singleton();
    { System.out.println("开始初始化变量"); }
    private Singleton(){

    }
    public static Singleton getInstance(){
        System.out.println("开始初始化danli");
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton.getInstance();
    }
}

/**
 * 懒汉模式（静态嵌套类）
 */
//public class Singleton {
//
//    private Singleton(){
//
//    }
//    private static class SingletonHolder{
//        static{ System.out.println("开始初始化静态变量"); }
//        private final static Singleton instance=new Singleton();
//        { System.out.println("开始初始化变量"); }
//    }
//    public static Singleton getInstance(){
//        System.out.println("开始初始化内部类");
//        return SingletonHolder.instance;
//    }
//
//    public static void main(String[] args) {
//       // Singleton.getInstance();
//        new Singleton.SingletonHolder();
//    }
//}