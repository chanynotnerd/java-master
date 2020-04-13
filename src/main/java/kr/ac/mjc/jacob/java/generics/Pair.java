package kr.ac.mjc.jacob.java.generics;

/**
 * key - value 한 쌍을 갖고 있는 클래스
 */
public class Pair<K, V> {
	private K key;
	private V value;

	public Pair() {
	}

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
}