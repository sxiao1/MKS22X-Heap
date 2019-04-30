public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    if((index * 2 + 1 < size && data[index] < data[index * 2 + 1]) || (index * 2 + 2 < size && data[index] < data[index * 2 + 2])){
      int greater = 0;//finding the greater index to swap with
      if(index * 2 + 2 >= size){
        greater = index * 2 + 1;
        int temp = data[index * 2 + 1];
        data[index * 2 + 1] = data[index];
        data[index] = temp;
      }
      else if(data[index * 2 + 2] > data[index * 2 + 1]){
        greater = index * 2 + 2;
        int temp = data[index * 2 + 2];//switching the values
        data[index * 2 + 2] = data[index];
        data[index] = temp;
      }
      else{
        greater = index * 2 + 1;
        int temp = data[index * 2 + 1];
        data[index * 2 + 1] = data[index];
        data[index] = temp;
      }
      pushDown(data, size, greater);//going down not only the branch that was swapped but also the second branch
      pushDown(data,size, index + 1);
    }
    else{
      if(index *2 + 1 <size){
        pushDown(data, size, index + 1);
      }
    }
  }
  private static void pushUp(int[]data,int index){
    if(((index - 1) / 2 >= 0 && index != 0 && data[index] >= data[(index - 1) / 2]) ){
    while(((index - 1) / 2 >= 0 && index != 0 && data[index] >= data[(index - 1) / 2]) ){
      int temp = data[(index -1) / 2];
      data[(index - 1)/ 2] = data[index];
      data[index] = temp;
      index = (index - 1) / 2;
    }
  }
    else{
      while(((index - 1) / 2 >= 0 && index != 0 && data[index] < data[(index - 1) / 2])){
        int temp = data[(index -1) / 2];
        data[(index - 1)/ 2] = data[index];
        data[index] = temp;
        index = (index - 1)/ 2;
      }
    }

  }
  public static void heapify(int[] nums){
    int size = nums.length;
    pushDown(nums, size, 0);
    pushDown(nums, size, 0);//twice to run through the branches and make sure they are in the right place
    //pushUp(nums, nums.length - 1);
  }
  public static void heapsort(int[] nums){
    /*int[] newNums = new int[nums.length];
    for(int i = 0; i < nums.length; i++){
      newNums[i] = nums[i];
    }
    heapify(newNums);
    for(int i = 0; i < nums.length;i++){
      nums[i] = newNums[i];
    }*/
    int first = nums[0];
    nums[0] = nums[nums.length - 1];
    nums[nums.length - 1] = first;
    pushDown(nums, nums.length, 0);
    pushDown(nums, nums.length,0);
  }
  public static void main(String[]args){
    int[] nums = {13,2,34,12,5,6,29,70,88};
    //heapify(nums);
    heapsort(nums);
    String s = "";
    for(int i = 0; i < nums.length; i++){
      s += nums[i] + ", ";
    }
    System.out.println(s);
  }
}
