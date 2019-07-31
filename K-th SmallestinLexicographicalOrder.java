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



//Efficient Solution took refrence from http://shirleyisnotageek.blogspot.com

class Solution {
    static int rstIndex = 0;
    private static int getIndex(long curr, int n) {
	    int rst = 0;
	    int num = 1;
	    while (curr <= n) {
	        rst += num;
	        curr *= 10;
	        num *= 10; //10~19, 100 ~199 ...
	 
	    }
	    curr /= 10;
	    num /= 10;
	    if (n < curr + num - 1) {
	        rst -= curr + num - 1 - n;
	    }
	    return rst;
	}
	 
	private static int getAns(String curr, int n, int k) {
	    rstIndex++;
	    if (rstIndex == k) {
	        return Integer.valueOf(curr);
	    }
	    int ans = -1;
	 
	    for (int i = 0; i <= 9; i++) {
	        int nextIndex = getIndex(Long.valueOf(curr + i), n);
	        if (rstIndex + nextIndex < k) {
	            rstIndex += nextIndex;
	        } else {
	            ans = getAns(curr + i, n, k);
	            break;
	        }
	    }
	    return ans;
	}
   
    public int findKthNumber(int n, int k) {
	     if (n < k) {
	        return -1;
	    }
	    int index = 0;
	    int ans = -1;
	    for (int i = 1; i <= 9; i++) {
	        int nextIndex = getIndex(i, n);
	        if (index + nextIndex < k) {
	            index += nextIndex;
	        } else {
	            rstIndex = index;
	            ans = getAns("" + i, n, k);
	            break;
	        }
	    }
	    return ans;
    }
}
