// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
// level : hard
//this solution gives TLE.
//Brute force Approach.
class Solution {
    
    static int compareOrder(String x , String y){
		int n = x.length();
		int m = y.length();
		int out = 0 ;
		int len = (m>n) ? n : m ;
		
		for(int i = 0 ; i < len ; i++){
			if(x.charAt(i)<y.charAt(i)){
				out= Integer.parseInt(x);
				break;
			}
			
			if(x.charAt(i)>y.charAt(i)){
				out= Integer.parseInt(y);
				break;
			}
				
		}
		
		if(out!=0) return out;
		else{
			out = (n>m)?Integer.parseInt(y):Integer.parseInt(x);
			return out ;
		}
		
	}
    
    public int findKthNumber(int n, int k) {
	    int [] arr = new int[n];
	    
	    for(int i = 0 ; i<n ; i++){
	    	arr[i] = i+1 ;
	    }
		
	    for(int i = 0 ; i<arr.length-1 ;i++){
	    	for(int j = i ; j<arr.length ; j++){
	    		int x = compareOrder(Integer.toString(arr[i]),Integer.toString(arr[j]));
	    		
	    		if(x!=arr[i]){
	    			int temp = arr[i] ;
	    			arr[i] = arr[j];
	    			arr[j] = temp ;
	    		}
	    	}
	    }
        return arr[k-1];
    }
}
