class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int key = i-j;
                if(!map.containsKey(key))
                {
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        for(List<Integer>list : map.values())
        {
            Collections.sort(list,Collections.reverseOrder());
        }
         for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                int key = i-j;
                List<Integer>list = map.get(key);
                mat[i][j] = list.remove(list.size()-1);
            }
        }
return mat;
    }
}