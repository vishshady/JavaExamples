package someExamples;

public class SinglyList<E> {

	private class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			setElement(e);
			setNext(n);
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private int size = 0;
	private Node<E> head = null;
	private Node<E> tail = null;

	public int size() {
		return size;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public E addFirst(E e) {
		head = new Node<>(e, head);
		if (isEmpty())
			tail = head;
		size++;
		return head.getElement();
	}

	public E addLast(E e) {
		Node<E> last = new Node<>(e, null);
		if (isEmpty()) 
			head = last;
		 else
			tail.setNext(last);
		tail = last;
		size++;
		return tail.getElement();
	}
	
	public E removeFirst(){
		if(isEmpty())
			return null;
		E element = head.element;
		head = head.getNext();
		size--;
		if(isEmpty())
			tail = null;
		return element;
	}
	
	public static void main(String[] args){
		SinglyList<String> s = new SinglyList<String>();
		System.out.println(s.addFirst("hi"));
		System.out.println(s.addLast("There"));
	}
}
