package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Basic Map implementation
 * 
 * @author Vishshady
 *
 * @param <K>
 * @param <V>
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

	ArrayList<MapEntry<K, V>> entries;

	public UnsortedTableMap() {
		entries = new ArrayList<>();
	}

	protected int getIndex(K key) {
		int n = entries.size();
		for (int i = 0; i < n; i++)
			if (entries.get(i).getkey().equals(key))
				return i;
		return -1;
	}

	public V get(K key) {
		int index = getIndex(key);
		if (index == -1)
			return null;
		return entries.get(index).getValue();
	}

	public V put(K key, V value) {
		int index = getIndex(key);
		if (index == -1) {
			entries.add(new MapEntry<K, V>(key, value));
			return null;
		}
		return entries.get(index).setValue(value);
	}

	public V remove(K key) {
		int index = getIndex(key);
		if (index == -1)
			return null;
		V v = entries.get(index).getValue();
		if (index != entries.size() - 1)
			entries.set(index, entries.get(entries.size() - 1));
		entries.remove(entries.size() - 1);
		return v;
	}

	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

	private class EntryIterator implements Iterator<Entry<K, V>> {
		int j = 0;

		public boolean hasNext() {
			return j < entries.size();
		}

		public Entry<K, V> next() {
			if (j == entries.size())
				throw new NoSuchElementException();
			return entries.get(j++);
		}

	}

	private class EntryIterable implements Iterable<Entry<K, V>> {

		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}

	}
}
