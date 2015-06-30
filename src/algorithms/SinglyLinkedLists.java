package algorithms;

import java.util.Arrays;

/**
 * Top of the list is Head and end is Tail. Each node will contains an element
 * or objects and reference to next node. Tail has null for next node reference.
 * 
 * @author Vishshady
 *
 */
public class SinglyLinkedLists<E> {

	private Node<E> head;
	private Node<E> tail;
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
		return head.element;
	}

	// Get last element or null
	public E last() {
		if (isEmpty())
			return null;
		return tail.element;
	}

	// Set the first node and update current tail if its null and update current
	// head
	public void setFirst(E e) {
		head = new Node<E>(e, head);
		if (isEmpty())
			tail = head;
		size++;
	}

	// Set the last node and update current head if its null and update current
	// tail
	public void setLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}

	// Remove first node. #Pop
	public E removeFirst() {
		if (isEmpty())
			return null;
		E copy = head.element;
		head = head.getNext();
		size--;
		if (isEmpty())
			tail = null;
		return copy;
	}

	private void setCopy(E e) {
		copy = Arrays.copyOf(copy, count = copy.length + 1);
		copy[count - 1] = e;
	}

	public Object[] getList() {
		if (isEmpty())
			return null;
		Node<E> n = head;
		do {
			E e = n.getElement();
			setCopy(e);
			n = n.getNext();

		} while (n != null);
		return copy;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		SinglyLinkedLists clone = (SinglyLinkedLists) o;
		Node a = head;
		Node b = clone.head;
		while (a != null) {
			if (!a.getElement().equals(b.getElement()))
				return false;
			a = a.getNext();
			b = b.getNext();
		}
		return true;
	}

	public static void main(String[] args) {

		// String type
		SinglyLinkedLists<String> list = new SinglyLinkedLists<String>();
		System.out.println(list.size());
		System.out.println("Head : " + list.first());
		System.out.println("Tail : " + list.last());
		list.setFirst("Shady");
		System.out.println("Head : " + list.first());
		System.out.println("Tail : " + list.last());
		list.setLast("!");
		list.setFirst("My Name is ");
		for (Object o : list.getList())
			System.out.print(String.valueOf(o));

		System.out.println();

		// int type
		SinglyLinkedLists<Integer> listI = new SinglyLinkedLists<Integer>();
		listI.setLast(5);
		for (int i = 4; i >= 0; i--)
			listI.setFirst(i);
		for (Object o : listI.getList())
			System.out.print((Integer) o + " ");
	}
}
