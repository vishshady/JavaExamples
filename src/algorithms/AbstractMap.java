package algorithms;

import java.util.Iterator;

/**
 * Abstract Map base class
 * 
 * @author Vishshady
 *
 * @param <K>
 * @param <V>
 */
public class AbstractMap<K, V> implements Map<K, V> {

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	public V get(K key) {
		return null;
	}

	public V put(K key, V value) {
		return null;
	}

	public V remove(K key) {
		return null;
	}

	public Iterable<K> keySet() {
		return new KeyIterable();
	}

	public Iterable<V> values() {
		return new ValueIterable();
	}

	public Iterable<Entry<K, V>> entrySet() {
		return null;
	}

	/**
	 * Inner static class for storing map entries
	 * 
	 * @author Vishshady
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected static class MapEntry<K, V> implements Entry<K, V> {
		private K k;
		private V v;

		public MapEntry(K key, V value) {
			k = key;
			v = value;
		}

		public K getkey() {
			return k;
		}

		public V getValue() {
			return v;
		}

		protected void setKey(K key) {
			k = key;
		}

		protected V setValue(V value) {
			V old = v;
			v = value;
			return old;
		}

	}

	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		public boolean hasNext() {
			return entries.hasNext();
		}

		public K next() {
			return entries.next().getkey();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * For Key Iterator
	 * 
	 * @author Vishshady
	 *
	 */
	private class KeyIterable implements Iterable<K> {
		public Iterator<K> iterator() {
			return (Iterator<K>) new KeyIterator();
		}
	}

	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		public boolean hasNext() {
			return entries.hasNext();
		}

		public V next() {
			return entries.next().getValue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	/**
	 * For Value Iterator
	 * @author Vishshady
	 *
	 */
	private class ValueIterable implements Iterable<V> {

		public Iterator<V> iterator() {
			return new ValueIterator();
		}

	}

}
