class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>list = new ArrayList<>();
        int ans =0;
        for(int i=1;i<=numRows;i++)
        {
            ans =1;
            List<Integer>temp = new ArrayList<>();
            temp.add(ans);
            for(int j=1;j<i;j++)
            {
                ans = ans*(i-j);
                ans =  ans/j;
                temp.add(ans);
            }
                    list.add(temp);
        }
        return list;

    }
}