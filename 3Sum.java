class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output_arr = new LinkedList();  
        
        for(int i = 0 ; i<nums.length ; i++){
            int start = i+1;
            int end = nums.length -1;
            
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            while(start<end) {
                
                if(end < nums.length -1 && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }
                if(nums[i]+nums[start]+nums[end] == 0){
                    output_arr.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                }else if(nums[i]+nums[start]+nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return output_arr;
    }
}
