package someExamples;
/**
 * Demonstrating sample multi thread model to show case synchronized
 * @author Vishshady
 *
 */
public class MultiThreadModel{
	//or you can add synchronized here 
	void MultiThreadModelMe(String msg) {
		System.out.print("["+msg);
		try {
			Thread.sleep(2000);
			System.out.print("]");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void test(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Execute");
	}
}

class MultiThreadModelme implements Runnable{
Thread t;
String msg;
MultiThreadModel c;

MultiThreadModelme(MultiThreadModel MultiThreadModel,String msg) {
	c = MultiThreadModel;
	this.msg = msg;
	t = new Thread(this);
	t.start();
}
	@Override
	public void run() {
//		new MultiThreadModel().MultiThreadModelMe(msg);
	
	synchronized (c) {
		c.MultiThreadModelMe(msg);
	}
		
	
	}	
}

class synch{
	public static void main(String[] args) {
		MultiThreadModel c = new MultiThreadModel();
		MultiThreadModelme one = new MultiThreadModelme(c, "First");
		MultiThreadModelme two = new MultiThreadModelme(c, "Second");
		MultiThreadModelme three = new MultiThreadModelme(c, "Third");
		try {
			one.t.join();
			two.t.join();
			three.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}