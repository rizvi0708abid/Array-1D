
import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());     
        int []array = new int[size];
        String []arrStr = br.readLine().trim().split(" ");
        
        for(int i=0;i<size;i++){
            array[i]=Integer.parseInt(arrStr[i]);
         }
        
        //Sort the array
        Arrays.sort(array);
        
        //make a count array of size of value equal to largest element in the array +1
        int [] nums = new int[array[array.length-1]+1];
        
        //populate the occurrence of each element in the array into the count array
        for(int n : array){
            nums[n]++;
        }
        
        
        int Q = Integer.parseInt(br.readLine());
        
        StringBuilder out = new StringBuilder("");
        
        //prepare the output based on the count of each element int the count array.
        while(Q-- > 0){
           int n = Integer.parseInt(br.readLine());    
           if(n <= array[array.length-1] && nums[n]!=0)    
              out.append(nums[n]+"\n");
           else
              out.append("NOT PRESENT" + "\n");
        }
        System.out.print(out);

    }
}
