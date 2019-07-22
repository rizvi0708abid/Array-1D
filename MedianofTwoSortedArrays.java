//https://leetcode.com/problems/median-of-two-sorted-arrays/
//Level : Hard

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length + nums2.length ;
        double [] arr = new double[N] ;
        int n = 0 ;
        int m = 0 ;
        
        //Merge the two sorted arrays into one
        for(int i = 0 ; i< N ;i++) {
            if(n <nums1.length && m < nums2.length && (nums1[n]<nums2[m])){
                arr[i] = nums1[n];
                n++;
            }else
            if(m < nums2.length && n< nums1.length && (nums1[n]>nums2[m])){
                arr[i] = nums2[m];
                m++;
            }else
            
            if(n<nums1.length){
                arr[i] = nums1[n];
                n++;
            }else
            
            if(m<nums2.length){
                arr[i] = nums2[m];
                m++;
            }
        }
        double median = 0;
        //check the length of merged array
        if(N%2==0){
            median = (arr[N/2]+arr[(N/2)-1])/2;
        }else{
            median = (arr[N/2]);
        }
        //return the median
        return median ;
    }
}
