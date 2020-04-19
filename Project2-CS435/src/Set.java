

public class Set<T, V extends Comparable<? super V>> implements Comparable<Set<T, V>>{
	T n;
	V property;
	
	public Set(T n, V property) {
		this.n = n;
		this.property = property;
	}
	
	public T getNode() {
		return this.n;
	}
	
	@Override
	public String toString() {
		return n.toString() + "=>" + this.property; 
	}

	@Override
	public int compareTo(Set<T, V> s) {
		return (this.property.compareTo(s.property)); 
	}
}
