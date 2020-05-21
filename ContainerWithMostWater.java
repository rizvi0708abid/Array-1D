class Solution {
    public int maxArea(int[] height) {
        
        int maxVol = 0;
        
        for(int i=0; i<height.length-1;i++){
            for(int j=height.length-1 ; j>0 && i!=j ; j--){
                int temp = height[j] > height[i] ? height[i]*Math.abs(j-i) : height[j]*Math.abs(j-i);
                maxVol = maxVol > temp ? maxVol : temp;
            }
        }
        
        return maxVol;
    }
}
