package solution;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyHashtable<K, V> implements Serializable {
	/*
	 * Achieved thread safe, following methods.
	 * 
	 * Compared to the official version, didn't achieve 
	 * fast fail(I should add another member variable recoding the times of changing), 
	 * clonable(I should implements interface Clonable and function clone), 
	 * several methods.
	 * Enumeration<K> keys(), Enumeration<V> elements(), Set<K> keySet(), Collection<V> values(), Set<Map.Entry<K, V>> entrySet()
	 * 
	 * N is the number of buckets, T is the length of linked list of one bucket may have.
	 * 
	 * time complexity:
	 * size() => O(1)
	 * isEmpty() => O(1)
	 * containsValue(Object value) => O(N + T)
	 * containsKey(Object key) => O(T)
	 * get(Object key) => O(N + T)
	 * put(K key, V value) => O(T)
	 * remove(Object key) => O(T)
	 * clear() => O(1)
	 * 
	 * space complexity:
	 * N
	 * */
	
	private static final class HashEntry<K, V> implements Entry<K, V>, Serializable {
		private static final long serialVersionUID = 1L;
		private HashEntry<K, V> next;
		private K key;
		private V value;

		HashEntry(K newKey, V newValue) {
			this.key = newKey;
			this.value = newValue;
		}

		@Override
		public int hashCode() {
			return ((this.key == null ? 0 : this.key.hashCode()) | (this.value == null ? 0 : this.value.hashCode()));
		}
	
		@Override
		public boolean equals(Object instance) {
	        if (instance instanceof HashEntry) {
	            HashEntry<K, V> hashInstance = (HashEntry<K, V>) instance;
	            K keyInstance = hashInstance.getKey();
	            V valueInstance = hashInstance.getValue();
	            if (keyInstance != null && valueInstance != null) {
	            	if (hashInstance.getKey() == this.key && hashInstance.getValue() == this.value) {
		            	return true;
		            }
	            	if (keyInstance.equals(this.key) && valueInstance.equals(this.value)) {
	            		return true;
	            	}
	            }
	            if (keyInstance == null && valueInstance == null) {
	            	return true;
	            }
	        }
	        return false;
		}

		@Override
		public String toString() {
			return this.getKey() + " = " + this.getValue();
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
	}

	private int size;
	private int threshold;
	private final float loadFactor;
	private HashEntry<K, V>[] buckets;
	
	private static final long serialVersionUID = 1L;
	private static final int CAPACITY = 11;
	private static final float LOADFACTOR = 0.75f;
	
	public MyHashtable(int initialCapacity, float loadFactor) {
		if (initialCapacity <= 0 || ! (loadFactor > 0))
			throw new IllegalArgumentException("Capacity or loadfator is negative!!!!");

		buckets = (HashEntry<K, V>[]) new HashEntry[initialCapacity];
		this.loadFactor = loadFactor;
		threshold = (int) (initialCapacity * loadFactor);
	}
	
	public MyHashtable() {
		this(CAPACITY, LOADFACTOR);
	}
	
	public synchronized int size() {
		return this.size;
	}

	public synchronized boolean isEmpty() {
		return this.size == 0;
	}

	private synchronized boolean contains(Object value) {
		if (value == null)
			throw new NullPointerException();

		for (int i = buckets.length - 1; i >= 0; i--) {
			HashEntry<K, V> links = this.buckets[i];
			while (links != null) {
				if (links.getValue().equals(value)) 
					return true;
				links = links.next;
			}
		}
		return false;  
	}

	public boolean containsValue(Object value) {
		return this.contains(value);
	}
	
	private int hash(Object key) {
		int hash = key.hashCode() % buckets.length;
		return hash < 0 ? -hash : hash;
	}

	public synchronized boolean containsKey(Object key) {
		HashEntry<K, V> links = buckets[this.hash(key)];
		while (links != null) {
			if (links.key.equals(key)) 
				return true;
			links = links.next;
		}
		return false;
	}

	public synchronized V get(Object key) {
		HashEntry<K, V> links = buckets[this.hash(key)];
		while (links != null) {
			if (links.key.equals(key)) 
				return links.value;
			links = links.next;
		}
		return null;
	}

	public synchronized V put(K key, V value) {
		int hashCode = hash(key);
		HashEntry<K, V> links = buckets[hashCode];
		
		if (value == null || key == null) 
			throw new NullPointerException();
		
		while (links != null) {
			if (links.key.equals(key)) {
				V r = links.value;
				links.value = value;
				return r;
			} else {
				links = links.next;
			}
		}
		
		if (++size > threshold) {
			this.rehash();
			hashCode = hash(key);
		}
		links = new HashEntry<K, V>(key, value);
		links.next = buckets[hashCode];
		buckets[hashCode] = links;
		return null;
	}

	private void rehash() {
		HashEntry<K, V>[] old = buckets;
		int newcapacity = (buckets.length * 2);
		threshold = (int) (newcapacity * loadFactor);
		buckets = (HashEntry<K, V>[]) new HashEntry[newcapacity];
		for (int i = old.length - 1; i >= 0; i--) {
			HashEntry<K, V> oldLinks = old[i];
			while (oldLinks != null) {
				int hashCode = hash(oldLinks.key);
				HashEntry<K, V> newLinks = buckets[hashCode];
				if (newLinks != null) {
					HashEntry next = newLinks.next;
					while (next != null) {
						newLinks = next;
						next = newLinks.next;
					}
					newLinks.next = oldLinks;
				} else {
					buckets[hashCode] = oldLinks;
				}
				HashEntry<K, V> next = oldLinks.next;
				oldLinks.next = null;
				oldLinks = next;
			}
		}
	}

	public synchronized V remove(Object key) {
		int hashCode = hash(key);
		HashEntry<K, V> links = buckets[hashCode];
		HashEntry<K, V> last = null;
		while (links != null) {
			if (links.key.equals(key)) {
				if (last == null)
					buckets[hashCode] = links.next;
				else
					last.next = links.next;
				size--;
				return links.value;
			}
			last = links;
			links = links.next;
		}
		return null;
	}

	public synchronized void clear() {
		if (this.size > 0) {
			Arrays.fill(buckets, null);
			this.size = 0;
		}
	}

	private class EntryIterator implements Iterator<HashEntry<K,V>> {
		private int count = size;
		private int length = buckets.length;
		private HashEntry<K, V> lastEntry;
		private HashEntry<K, V> nextEntry;

		public EntryIterator() {}

		public boolean hasNext() {
			return this.count > 0;
		}

		public HashEntry<K, V> next() {
			if (this.count == 0)
				throw new NoSuchElementException();

			this.count--;
			HashEntry<K, V> entry = this.nextEntry;
			while (entry == null) 
				if (this.length <= 0) 
					return null;
				else
					entry = buckets[--this.length];
			this.nextEntry = entry.next;
			this.lastEntry = entry;
			return entry;
		}

		public void remove() {
			if (this.lastEntry == null) 
				throw new IllegalStateException();

			MyHashtable.this.remove(this.lastEntry.key);
			this.lastEntry = null;
		}
	}

	public synchronized String toString() {
		Iterator<HashEntry<K, V>> entries = new EntryIterator();
		StringBuffer stringBuffer = new StringBuffer("{");
		for (int pos = size; pos > 0; pos--) {
			stringBuffer.append(entries.next());
			if (pos > 1)
				stringBuffer.append(", ");
		}
		stringBuffer.append("}");
		return stringBuffer.toString();
	}

}