package someExamples;

public class InterthreadComm {
	public static void main(String[] args) {
		Queue q = new Queue();
		new Producer(q, 5);
		new Consumer(q, 5);
	}
}

class Queue {
	int i;
	boolean ready = false;

	synchronized void put(int i) {

		while (ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Put : " + i);
		this.i = i;
		ready = true;
		notify();
	}

	synchronized int get() {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Got : " + i);
		ready = false;
		notify();
		return i;
	}
}

class Producer implements Runnable {
	Queue q;
	int i;
	Thread t;

	Producer(Queue q, int loop) {
		this.q = q;
		i = loop;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (i-- > 0)
			q.put(i);
	}
}

class Consumer implements Runnable {
	Queue q;
	Thread t;
	int loop;

	Consumer(Queue q, int loop) {
		this.q = q;
		this.loop = loop;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (loop-- > 2)
			q.get();
	}
}