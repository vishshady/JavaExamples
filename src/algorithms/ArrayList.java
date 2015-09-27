package algorithms;

import java.util.Arrays;

/**
 * Linear Array Based Approach
 *
 * @param <E>
 * @author Vishshady
 */
public class ArrayList<E> implements List<E> {

    private enum Type {
        ASCENDING, DESCENDING
    }

    protected E[] data;
    protected int size = 0;
    protected final static int CAPACITY = 10;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /*
    Length of an ArrayList
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns value by index but does not delete from list
     * @param i index
     * @return value
     * @throws IndexOutOfBoundsException
     */
    public E get(int i) throws IndexOutOfBoundsException {
        isValidIndex(i, size());
        return data[i];
    }

    /**
     * Overwrites the value to the list and returns the replaced value.
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        isValidIndex(i, size());
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Adds new value to the list and returns the added value.
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public E add(int i, E e) throws IndexOutOfBoundsException {
        isValidIndex(i, size() + 1);
        if (size() + 1 == data.length)
            resize();
        if (i != size())
            System.arraycopy(data, i, data, i + 1, size() - i);
        data[i] = e;
        size++;
        return e;
    }

    protected void resize() {
        E[] temp = (E[]) new Object[data.length + CAPACITY];
        System.arraycopy(data, 0, temp, 0, size());
        data = temp;
    }

    /**
     * Resize the list with the specified index
     * @param CAPACITY
     */
    public void resize(int CAPACITY) {
        E[] temp = (E[]) new Object[data.length + CAPACITY];
        System.arraycopy(data, 0, temp, 0, size());
        data = temp;
    }

    /**
     * Adds new value to the list and returns the added value.
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public E add(E e) throws IndexOutOfBoundsException {
        if (size() + 1 == data.length)
            resize();
        data[size++] = e;
        return e;
    }

    /**
     * Removes value from list and returns removed value
     * @param i
     * @return
     * @throws IndexOutOfBoundsException
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        isValidIndex(i, size());
        E e = data[i];
        int elementsAffected = size - (i + 1);
        if (elementsAffected > 0)
            System.arraycopy(data, i + 1, data, i, elementsAffected);
        data[size() - 1] = null;
        size--;
        return e;
    }

    protected boolean isValidIndex(int index, int size) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return true;
    }

    /**
     * Returns array
     * @return
     */
    public E[] getList() {
        if (isEmpty())
            return null;
        return Arrays.copyOf(data, size());
    }

    /**
     * Sorts by user defined lambdas
     * @param c
     */
    public void sort(MyComparator<? super E> c) {
        mergeSort(data = getList(), c);
    }

    /**
     * Sorts by enum ASCENDING or DESCENDING
     * @param T
     */
    public void sort(Type T) {
        switch (T) {
            case ASCENDING:
                mergeSort(data = getList(), (a, b) -> {
                    if (a instanceof Integer)
                        return ((Integer) a).compareTo((Integer) b);
                    else if (a instanceof String)
                        return ((String) a).compareTo((String) b);
                    return 0;
                });
                break;
            case DESCENDING:
                mergeSort(data = getList(), (a, b) -> {
                    if (a instanceof Integer)
                        return ((Integer) b).compareTo((Integer) a);
                    else if (a instanceof String)
                        return ((String) b).compareTo((String) a);
                    return 0;
                });
                break;
        }
    }


    /**
     * Sorts by default ASCENDING
     */
    public void sort() {
        sort(Type.ASCENDING);
    }

    private void merge(E[] e, E[] e1, E[] e2, MyComparator<? super E> c) {
        int k = e.length;
        int i = 0;
        int j = 0;
        while (i + j < k) {
            if (j == e2.length || (i < e1.length && c.compare(e1[i], e2[j]) <= 0))
                e[i + j] = e1[i++];
            else
                e[i + j] = e2[j++];
        }
    }

    private void mergeSort(E[] e, MyComparator<? super E> c) {
        int n = e.length;
        if (n < 2)
            return;
        int mid = n / 2;
        E[] e1 = Arrays.copyOfRange(e, 0, mid);
        E[] e2 = Arrays.copyOfRange(e, mid, n);
        mergeSort(e1, c);
        mergeSort(e2, c);
        merge(e, e1, e2, c);
    }

    public static void main(String[] args) {
//        ArrayList<Integer> l = new ArrayList<>();
//        l.add(2);
//
//        l.add(4);
//        l.add(3);
//        l.add(1);
//        l.sort((a, b) -> b - a);


        ArrayList<String> l = new ArrayList<>();
        l.add("B");
        l.add("A");
        l.add("D");
        l.add("C");

        // Sorting of strings in Descending order using Lambdas(Anonymous class)
        l.sort((a, b) -> b.compareTo(a));
        System.out.println(Arrays.toString(l.getList()));

        //Default Ascending sort
        l.sort();
        System.out.println(Arrays.toString(l.getList()));

        //Enum Descending sort
        l.sort(Type.DESCENDING);
        System.out.println(Arrays.toString(l.getList()));
    }
}
