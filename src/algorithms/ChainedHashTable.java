package algorithms;

public class ChainedHashTable<K, V> extends AbstractHashMap<K, V> {
	UnsortedTableMap<K, V>[] table;

	public ChainedHashTable() {
		super();
	}

	public ChainedHashTable(int capacity) {
		super(capacity);
	}

	public ChainedHashTable(int capacity, int prime) {
		super(capacity, prime);
	}

	@SuppressWarnings("unchecked")
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new Object[capacity];
	}

	protected V bucketGet(int h, K key) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		return bucket.get(key);
	}

	protected V bucketPut(int h, K key, V value) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			bucket = table[h] = new UnsortedTableMap<K, V>();
		int oldSize = bucket.size();
		V answer = bucket.put(key, value);
		n += bucket.size() - oldSize;
		table[h] = bucket;
		return answer;
	}

	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= oldSize - bucket.size();
		table[h] = bucket;
		return answer;
	}

	public Iterable<Entry<K, V>> entrySet() {
		return null;
	}
}
