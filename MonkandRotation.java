import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


class TestClass {
 
 
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());               
        StringBuilder output = new StringBuilder("");
        
        while(T-->0){
            String [] inps = br.readLine().split(" ");
            int N = Integer.parseInt(inps[0]);
            int K = Integer.parseInt(inps[1]);
            String [] input = br.readLine().split(" ");
            
            //Creating the output array to keep the rotated elements
            String [] out = new String[N];
            
                for(int i = 0 ; i< N ; i++){
                //moving forward the elements by K places and taking the modulo 
                //for keeping the index within N i.e between 0 to N-1
                    int index = ((i+K)%(N));
                    out[index] = input[i];
                }
                
                //appending the array elements for each test cases and adding new line in the end
                for(String s : out)  output.append(s+" ");
                output.append("\n");
         
        } 
        
        System.out.print(output);
       
    }
}
