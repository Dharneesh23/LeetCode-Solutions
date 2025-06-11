class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length<k)
        {
            return -1;
        }
        if(k==1)
        {
            return arrTol(nums);
        }
        int left = arrMax(nums);
        int right =  arrTol(nums);
        while(left<=right)
        {
            int mid = (left+right)/2;
            int split = cal(nums,mid);
            if(split>k)
            {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
    public int arrMax(int[]arr)
    {
        int max =0;
        for(int i:arr)
        {
            max = Math.max(max,i);
        }
        return max ;
    }
    public int arrTol(int[]arr)
    {
        int total =0;
        for(int i : arr)
        {
            total+=i;
        }
        return total;
    }
    public int cal(int[]arr,int mid)
    {
        int spl =1;
        int curr = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(curr+arr[i]<=mid)
            {
                curr+=arr[i];
            }else{
                spl++;
                curr = arr[i];
            }
        }
        return spl;
    }
}