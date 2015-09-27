package algorithms;

public interface List<E> {
	int size();

	boolean isEmpty();
	
	E get(int i) throws IndexOutOfBoundsException;

	E set(int i,E e) throws IndexOutOfBoundsException;
	
	E add(int i, E e) throws IndexOutOfBoundsException;
	
	E add(E e) throws IndexOutOfBoundsException;
	
	E remove(int i) throws IndexOutOfBoundsException;
}
