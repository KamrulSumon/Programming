/**
 * HashMap implementation in Java
 */
package com.sumon.prog.ds;

public class HashMap<K, V> {
	private final int DEFAULT_SIZE = 16;
	private Entry<K, V>[] bucket;

	/* Entry in HashMap */
	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public HashMap() {
		bucket = new Entry[DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			bucket[i] = null;
		}
	}

	// insert a key-value in hashmap
	public void put(K nKey, V val) {
		if (nKey == null)
			return;

		int hash = hash(nKey);
		Entry<K, V> entry = new Entry<K, V>(nKey, val, null);

		if (bucket[hash] == null) {
			bucket[hash] = entry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = bucket[hash];

			while (current != null) {
				if (current.key.equals(nKey)) {
					if (previous == null) {
						entry.next = current.next;
						bucket[hash] = entry;
						return;
					} else {
						entry.next = current.next;
						previous.next = entry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}

			previous.next = entry;
		}
	}

	//remove key-value from HashMap
	public boolean remove(K dKey) {
		int hash = hash(dKey);

		if (bucket[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = bucket[hash];

			while (current != null) {
				if (current.key.equals(dKey)) {
					if (previous == null) {
						bucket[hash] = current.next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
		}
		return false;
	}

	// get a value from map
	public V get(K key) {
		int hash = hash(key);
		if (bucket[hash] == null) {
			return null;
		} else {
			Entry<K, V> entry = bucket[hash];

			while (entry != null) {
				if (entry.key.equals(key)) {
					return entry.value;
				}
				entry = entry.next;
			}
		}
		return null;
	}

	// display key-value in HashMap
	public void display() {
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			if (bucket[i] != null) {
				Entry<K, V> entry = bucket[i];
				while (entry != null) {
					System.out.println(entry.key + "=" + entry.value);
					entry = entry.next;
				}
			}
		}
	}

	// calculate hash value
	int hash(K key) {
		return Math.abs(key.hashCode()) % DEFAULT_SIZE;
	}

}

/**
 * Thanks: AnkitMittal
 */
