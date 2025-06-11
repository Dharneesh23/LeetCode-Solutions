class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set = new HashSet<>();
        ArrayList<Integer>list = new ArrayList<>();
        HashSet<Integer>set2 = new HashSet<>();
        for(int i : nums1)
        {
            set.add(i);
        }
        for(int i : nums2)
        {
            if(set.contains(i)&&!set2.contains(i))
            {
                list.add(i);
                set2.add(i);
            }
        }
        int[]arr = new int[list.size()];
         int index =0;
         for(int i : list)
         {
            arr[index] = i;
            index++;
         }
         return arr;
    }
}