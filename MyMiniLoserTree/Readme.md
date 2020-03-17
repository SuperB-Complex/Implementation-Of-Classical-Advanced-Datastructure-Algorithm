Assuming that the input size can not fit the size of memory.
  The input can be upgraded into file handlers if needed.
  
  N is the number of inputing lists;
  M is the number of all elements;
  
  time complexity:
  Initiate class MyMiniLoserTree. => O(logN)
  Build MyMiniLoserTree. => O(N)
  Adjust MyMiniLoserTree. => O(logN)
  Sort MyMiniLoserTree. => O(MlogN)
   adjust method => O(logN)
  	calling (M - N) times => M times
  
  space complexity:
  3  N