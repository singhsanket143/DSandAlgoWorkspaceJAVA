package HashTableGui;

public class Hashtable<K extends Comparable<K>, V> {
	class Node implements Comparable<Node>{
		K key; 
		V value;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Hashtable<K, V>.Node o) {
			return this.key.compareTo(o.key);
		}
	}
	
	int size;
	LinkedList<Node>[] lists;
	public static final int DEFAULT_SIZE = 4;
	
	public Hashtable(){
		this.size = 0;
		this.lists = new LinkedList[DEFAULT_SIZE];
	}
	
	public V get(K key) throws Exception{
		V retVal = null;
		int bucketIndex = this.getBucketIndex(key);
		
		LinkedList<Node> bucket = this.lists[bucketIndex];
		Node htNode = new Node(key, null);
		
		if(bucket == null){
			return null;
		}
		else {
			int foundAt = bucket.find(htNode);
			if(foundAt == -1){
				return null;
			}
			else {
				retVal = bucket.getAt(foundAt).value;
			}
		}
		
		return retVal;
	}
	
	public V remove(K key) throws Exception{
		V retVal = null;
		int bucketIndex = this.getBucketIndex(key);
		
		LinkedList<Node> bucket = this.lists[bucketIndex];
		Node htNode = new Node(key, null);
		
		if(bucket == null){
			return null;
		}
		else {
			int foundAt = bucket.find(htNode);
			if(foundAt == -1){
				return null;
			}
			else {
				retVal = bucket.getAt(foundAt).value;
				bucket.removeAt(foundAt);
				this.size--;
			}
		}
		
		return retVal;
	}
	
	public void put(K key, V value) throws Exception{
		int bucketIndex = this.getBucketIndex(key);
		
		LinkedList<Node> bucket = this.lists[bucketIndex];
		Node htNode = new Node(key, value);
		
		if(bucket == null){
			this.lists[bucketIndex] = new LinkedList<>();
			bucket = this.lists[bucketIndex];
			
			bucket.addLast(htNode);
			this.size++;
		}
		else {
			int foundAt = bucket.find(htNode);
			if(foundAt == -1){
				bucket.addLast(htNode);
				this.size++;
			}
			else {
				Node nodeToUpdate = bucket.getAt(foundAt);
				nodeToUpdate.value = value;
			}
		}
		
		double loadFactor = (this.size * 1.0)/ this.lists.length;
		if(loadFactor > 2.0){
			this.rehash();
		}
	}
	
	private int getBucketIndex(K key){
		int retVal = key.hashCode();
		
		retVal = Math.abs(retVal);
		retVal = retVal % this.lists.length;
		
		return retVal;
	}
	
	private void rehash() throws Exception{
		LinkedList<Node>[] temp = this.lists;
		
		this.size = 0;
		this.lists = new LinkedList[2 * temp.length];
		
		for(int i = 0; i < temp.length; i++){
			if(temp[i] != null){
				while(!temp[i].isEmpty()){
					Node nodeTobeAdded = temp[i].removeLast();
					this.put(nodeTobeAdded.key, nodeTobeAdded.value);
				}
			}
		}
	}
}

