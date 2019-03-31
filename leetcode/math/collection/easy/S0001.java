package leetcode.math.collection.easy;

import my.utils.CollectionOutput;

public class S0001 {

	public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j]==target){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
	
	
	public static void main(String[] args) {
		S0001 sol = new S0001();
		int[] nums = new int[]{2,7,11,15};
		int target = 9;
		int[] index = sol.twoSum(nums, target);
		CollectionOutput.arrToString(index);
	}
}
