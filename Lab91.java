public class Lab91 extends Thread {
	public static void main(String[] args) {
		GoodMorning t1 = new GoodMorning();
		Thread t2 = new Thread(t1);
		t2.start();

		GoodAfternoon t3 = new GoodAfternoon();
		Thread t4 = new Thread(t3);
		t4.start();
	} 
}

class GoodMorning implements Runnable {
	public void run() {
		try {
			System.out.println("Good Morning");
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class GoodAfternoon implements Runnable {
	public void run() {
		try {
			System.out.println("Good Afternoon");
			Thread.sleep(3000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}