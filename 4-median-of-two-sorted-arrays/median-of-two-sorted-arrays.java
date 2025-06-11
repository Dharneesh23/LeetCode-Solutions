class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]arr =  new int[nums1.length+nums2.length];
        int index =0;
        for(int i=0;i<nums1.length;i++)
        {
            arr[index] = nums1[i];
            index++;
        }
        for(int i=0;i<nums2.length;i++)
        {
            arr[index] = nums2[i];
            index++;
        }
        Arrays.sort(arr);
        int n = arr.length;
        if(n%2==0)
        {
           return (arr[n/2-1]+arr[n/2])/2.0;
        }else{
            return arr[n/2];
        }
        
    }
}