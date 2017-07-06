package javaSrc;

public class HelloWorld {

	public static void main(String[] args) {
//		String str1= "a";
//		String str2 = str1+"b";
//		String s ="ab";
//		String s3= "a"+"b";
//		System.out.println(str2 =="ab");
//		System.out.println(s3 =="ab");
		Runner1 runner1 = new Runner1();
		Runner2 runner2 = new Runner2();
//      Thread(Runnable target) 分配新的 Thread 对象。
		Thread thread1 = new Thread(runner1);
		Thread thread2 = new Thread(runner2);
      thread1.start();
      thread2.start();
//		thread1.run();
//		thread2.run();


	}


	static int p1() {
		System.out.println("try");
		return 1;
	}

	static int p2() {
		System.out.println("finally");
		return 2;
	}

	static int test() {

		try {
			while (true)
				break;
			return p1();

		} finally {
			return p2();
		}
	}


}
class Runner1 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner1运行状态——————————" + i);
		}
	}
}

class Runner2 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner2运行状态==========" + i);
		}
	}

}
