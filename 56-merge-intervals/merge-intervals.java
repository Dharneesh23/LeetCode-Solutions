class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>list = new ArrayList<>();
        int index = 0;
        while(index<intervals.length)
        {
        int start = intervals[index][0];
        int currend = intervals[index][1];
        while(index<intervals.length-1&&currend>=intervals[index+1][0])
        {
            currend = Math.max(currend,intervals[index+1][1]);
            index++;
        }
        int end = currend;
        list.add(new int[]{start,end});
        index++;
        }
        index=0;
        int[][]arr =new int[list.size()][2];
        for(int[]ar : list)
        {
            arr[index]=ar;
            index++;
        }
        return arr;
    }
}