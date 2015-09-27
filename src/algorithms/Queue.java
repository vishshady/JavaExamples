package algorithms;

public interface Queue<E> {

	int size();
	boolean isEmpty();
	void enQueue(E e);
	E deQueue(E e);
	E first();

 }
