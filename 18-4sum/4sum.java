class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j>i+1&&nums[j]==nums[j-1])
                
                    continue;
            int left = j+1;
            int right = nums.length-1;
            long target2 = (long)target-nums[i]-nums[j];
            while(left<right)
            {
                int sum = nums[left]+nums[right];
                if(sum==target2)
                {
                   list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                
                while(left<right&&nums[left]==nums[left+1])
                left++;
                while(left<right&&nums[right]==nums[right-1])
                right--;
                left++;
                right--;
                }
                else if(sum<target2)
                {
                    left++;
                }else{
                    right--;
                }
            }
            }
        }
        return list;
    }
}