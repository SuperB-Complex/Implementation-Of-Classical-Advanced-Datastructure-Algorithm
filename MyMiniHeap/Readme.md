
  Assuming that the input size can fit the size of memory.
  
  N is the number of all elements;
 
  time complexity:
  Put all element into an array. => O(N)
  Build MiniHeap. => O(N)
  Sort MiniHeap. => O(NlogN)
   popMini method => O(logN)
   calling N times
  
  space complexity:
  N
