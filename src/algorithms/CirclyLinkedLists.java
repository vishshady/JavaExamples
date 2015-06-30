package algorithms;

import java.util.Arrays;

public class CirclyLinkedLists<E> {

	Node<E> tail;
	private int size;
	private Object[] copy = new Object[0];
	private int count = 0;

	/*
	 * Node nested class, which stores an instance of element and reference node
	 * in a node
	 */
	public static class Node<E> {
		private E element;
		private Node<E> next;

		/*
		 * Constructor to maintain detail of element in a node and next
		 * reference.
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

		public Node<E> getNext() {
			return next;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	// Get size
	public int size() {
		return size;
	}

	// Get First element or null
	public E first() {
		if (isEmpty())
			return null;
		return tail.getNext().element;
	}

	// Get last element or null
	public E last() {
		if (isEmpty())
			return null;
		return tail.element;
	}

	public void setFirst(E e) {
		if (isEmpty()) {
			tail = new Node<E>(e, null);
			tail.setNext(tail);
		} else
			tail.setNext(new Node<E>(e, tail.getNext()));
		size++;
	}

	public void setLast(E e) {
		setFirst(e);
		tail = tail.getNext();
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		Node<E> head = tail.getNext();
		if (tail == head)
			tail = null;
		else
			tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
	
	private void setCopy(E e) {
		copy = Arrays.copyOf(copy, count = copy.length + 1);
		copy[count - 1] = e;
	}

	public Object[] getList() {
		int count = size();
		if (isEmpty())
			return null;
		Node<E> n = tail.getNext();
		do {
			E e = n.getElement();
			setCopy(e);
			n = n.getNext();
			count--;

		} while (count != 0);
		return copy;
	}

	public static void main(String[] args) {
		CirclyLinkedLists<Integer> c = new CirclyLinkedLists<Integer>();
		c.setFirst(2);
		c.setLast(3);
		c.setLast(4);
		c.removeFirst();
		c.setFirst(2);
		c.setFirst(1);
		c.setLast(5);
		
		for (Object o : c.getList())
			System.out.print((Integer) o+" ");
	}

}
