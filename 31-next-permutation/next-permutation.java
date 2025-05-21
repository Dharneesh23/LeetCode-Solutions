class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                pivot = i;
                break;
            }
        }
        if(pivot==-1)
        {
            Arrays.sort(nums);
            return;
        }
        for(int i=nums.length-1;i>pivot;i--)
        {
            if(nums[i]>nums[pivot])
            {
                swap(nums,pivot,i);
                break;
            }
        }
        reverse(nums,pivot+1,nums.length-1);
    }
    public void reverse(int[]arr,int start,int end)
    {
        while(start<end)
        {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    public void swap(int[]arr,int start,int end)
    {
        
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

        }
    }
