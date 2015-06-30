package algorithms;

import java.util.Arrays;

import algorithms.SinglyLinkedLists.Node;

/**
 * Doubly liked list has sentinels as header and trailer where it keeps the
 * references of head and tail. Each node have record of previous and next node.
 * 
 * @author Vishshady
 *
 */
public class DoublyLinkedList<E> {

	private Node<E> header;
	private Node<E> trailer;
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
		private Node<E> prev;

		/*
		 * Constructor to maintain detail of element in a node and next
		 * reference.
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			setPrev(p);
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

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> p) {
			this.prev = p;
		}
	}

	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
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
		return header.getNext().getElement();
	}

	// Get last element or null
	public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		return remove(header.getNext());
	}

	public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}

	public void addBetween(E e, Node<E> predecessor, Node<E> sucessor) {
		Node<E> newest = new Node<E>(e, predecessor, sucessor);
		predecessor.setNext(newest);
		sucessor.setPrev(newest);
		size++;
	}

	public E remove(Node<E> node) {
		Node<E> successor = node.getNext();
		Node<E> predecessor = node.getPrev();
		successor.setPrev(predecessor);
		predecessor.setNext(successor);
		size--;
		return node.getElement();
	}

	private void setCopy(E e) {
		copy = Arrays.copyOf(copy, count = copy.length + 1);
		copy[count - 1] = e;
	}

	public Object[] getList() {
		if (isEmpty())
			return null;
		Node<E> n = header.getNext();
		do {
			E e = n.getElement();
			setCopy(e);
			n = n.getNext();

		} while (n != null);
		return copy;
	}

}
