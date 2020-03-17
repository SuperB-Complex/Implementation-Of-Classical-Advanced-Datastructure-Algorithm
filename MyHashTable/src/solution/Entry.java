package solution;

public interface Entry<K, V> {
    K getKey();

    V getValue();

    int hashCode();
    
    boolean equals(Object o);
}
