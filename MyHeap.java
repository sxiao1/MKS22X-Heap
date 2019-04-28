public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    if((index * 2 + 1 < size && data[index] < data[index * 2 + 1]) || (index * 2 + 2 < size && data[index] < data[index * 2 + 2])){
      int greater = 0;
      if(data[index * 2 + 2] > data[index * 2 + 1]){
        greater = index * 2 + 2;
        int temp = data[index * 2 + 2];
        data[index * 2 + 2] = data[index];
        data[index] = temp;
      }
      else{
        greater = index * 2 + 1;
        int temp = data[index * 2 + 1];
        data[index * 2 + 1] = data[index];
        data[index] = temp;
      }
      pushDown(data, size, greater);
      pushDown(data,size, index + 1);
    }
    else{
      if(index *2 + 1 <size){
        pushDown(data, size, index + 1);
      }
    }
  }
  public static void main(String[]args){
    int[] nums = {13,2,34,12,5,6,29,70,88};
    pushDown(nums, 9, 0);
    String s = "";
    for(int i = 0; i < nums.length; i++){
      s += nums[i] + ", ";
    }
    System.out.println(s);
  }
}
