class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length==0||nums.length<2)
        {
            return 0;
        }
        return sort(nums,0,nums.length-1);
    }
    public int sort(int[]arr,int left,int right)
    {
        int count =0;
        if(left<right)
        {
            int mid = left+(right-left)/2;
             count+=sort(arr,left,mid);
             count+=sort(arr,mid+1,right);
             count+=pair(arr,left,mid,right);
             merge(arr,left,mid,right);
        }
        return count;
    }
   public int pair(int[]arr,int left,int mid,int right)
   {
        int  count=0;
        int j =mid+1;
        for(int i=left;i<=mid;i++)
        {
            while(j<=right&&(long)arr[i]>2L*arr[j])
            {
                j++;
            }
            count+=j-(mid+1);
        }
        return count;
   }
    public void merge(int[]arr,int left,int mid,int right)
    {
      List<Integer>list = new ArrayList<>();
      int i = left;
      int j = mid+1;
      while(i<=mid&&j<=right)
      {
        if(arr[i]<=arr[j])
        {
            list.add(arr[i]);
            i++;
        }else{
            list.add(arr[j]);
            j++;
        }
      }
      while(i<=mid)
      {
        list.add(arr[i]);
        i++;
      }
      while(j<=right)
      {
        list.add(arr[j]);
        j++;
      }
     for(int k=0;k<list.size();k++)
     {
        arr[left+k] = list.get(k);
     }
    }
}