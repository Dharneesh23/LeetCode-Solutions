class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans =0;
        while(left<right)
        {
            int with =  right-left;
            int hight = Math.min(height[left],height[right]);
            int water = with*hight;
            ans = Math.max(ans,water);
            if(height[left]<height[right])
            {
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}