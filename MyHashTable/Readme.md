
  Achieved thread safe, following methods.
  
  Compared to the official version, didn't achieve 
  fast fail(I should add another member variable recoding the times of changing), 
  clonable(I should implements interface Clonable and function clone), 
  several methods.
  Enumeration<K> keys(), Enumeration<V> elements(), Set<K> keySet(), Collection<V> values(), Set<Map.Entry<K, V>> entrySet()
  
  N is the number of buckets, T is the length of linked list of one bucket may have.
  
  time complexity:
  size() => O(1)
  isEmpty() => O(1)
  containsValue(Object value) => O(N + T)
  containsKey(Object key) => O(T)
  get(Object key) => O(N + T)
  put(K key, V value) => O(T)
  remove(Object key) => O(T)
  clear() => O(1)
  
  space complexity:
  N
