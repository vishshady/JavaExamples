package algorithms;

import java.util.Random;

/**
 * Abstract class for all HashTable
 * 
 * @author Vishshady
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
	protected int n = 0;
	protected int capacity;
	protected int prime;
	protected long scale, shift;

	public AbstractHashMap() {
		this(17);
	}

	public AbstractHashMap(int capacity) {
		this(capacity, 109345121);
	}

	public AbstractHashMap(int capacity, int prime) {
		Random rand = new Random();
		this.prime = prime;
		this.capacity = capacity;
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}

	public int hashValue(K key) {
		return (int) (Math.abs((key.hashCode() * scale + shift) % prime) % capacity);
	}

	public V get(K key) {
		return bucketGet(hashValue(key), key);
	}

	public V put(K key, V value) {
		V answer = bucketPut(hashValue(key), key, value);
		if (n > capacity / 2) {
			resize(2 * capacity - 1);
		}
		return answer;
	}

	public V remove(K key) {
		return bucketRemove(hashValue(key), key);
	}

	public void resize(int newCap) {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
		for (Entry<K, V> e : entrySet())
			buffer.add(e);
		capacity = newCap;
		createTable();
		n = 0;
		for (int i = 0; i < buffer.size(); i++) {
			Entry<K, V> e = buffer.get(i);
			put(e.getkey(), e.getValue());
		}

	}

	protected abstract void createTable();

	protected abstract V bucketGet(int h, K k);

	protected abstract V bucketPut(int h, K k, V v);

	protected abstract V bucketRemove(int h, K k);
}
