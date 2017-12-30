package Lecture28.story;

public class HashTable<K, V> {

	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}

		@Override
		public String toString() {
			return "{" + this.key + ":" + this.value + "}";
		}
	}

	private LinkedList<HTPair>[] BucketArray;

	private int size;// total no. of elements n
	public static final int Default_Capacity = 10;

	public HashTable() {
		this(Default_Capacity);
	}

	public HashTable(int capacity) {
		this.BucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.BucketArray.length;
		return bi;
	}

	public void put(K key, V value) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.BucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new LinkedList();
			bucket.addlast(pta);
			this.size++;
			this.BucketArray[bi] = bucket;
		} else {
			int foundAt = bucket.find(pta);
			if (foundAt == -1) {
				bucket.addlast(pta);
				this.size++;
			} else {
				HTPair ListPair = bucket.getat(foundAt);
				ListPair.value = pta.value;
			}
		}
		double lambda = (this.size * 1.0) / (this.BucketArray.length);
		if (lambda > 2.0) {
			this.rehash();
		}
	}

	public V get(K key) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.BucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int foundAt = bucket.find(ptf);
			if (foundAt == -1) {
				return null;
			} else {
				HTPair ListPair = bucket.getat(foundAt);
				return ListPair.value;
			}
		}
	}

	public V remove(K key) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.BucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int foundAt = bucket.find(ptf);
			if (foundAt == -1) {
				return null;
			} else {
				HTPair ListPair = bucket.getat(foundAt);

				bucket.removeat(foundAt);
				this.size--;

				return ListPair.value;
			}
		}
	}

	public void rehash() throws Exception {
		LinkedList<HTPair>[] oba = this.BucketArray;
		this.BucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
		this.size = 0;
		for (LinkedList<HTPair> ob : oba) {
			while (ob != null && !ob.isempty()) {
				HTPair op = ob.removefirst();
				this.put(op.key, op.value);
			}
		}

	}

	public void display() {
		for (LinkedList<HTPair> buckets : this.BucketArray) {
			if (buckets != null) {
				buckets.display();
			} else {
				System.out.println("Null");
			}
		}
	}
}
