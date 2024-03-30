public class Lab92 {
	public static void main(String[] args) {
		Odd t1 = new Odd();
		t1.start();
		try {
			t1.join();
		}
		catch(Exception e) {
				e.printStackTrace();
		}
		Even t2 = new Even();
		t2.start();
	}
}

class Odd extends Thread {
	public void run() {
		for(int i=1;i<=20;i++) {
			if(i%2!=0){
				System.out.println(i);
			}
		}
	}
}

class Even extends Thread {
	public void run() {
		for(int i=1;i<=20;i++) {
			if(i%2==0){
				System.out.println(i);
			}
		}
	}
}