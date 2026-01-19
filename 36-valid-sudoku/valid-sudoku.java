import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSets = new ArrayList<>();
        List<Set<Character>> colSets = new ArrayList<>();
        List<Set<Character>> boxSets = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                if (rowSets.get(i).contains(c) || 
                    colSets.get(j).contains(c) || 
                    boxSets.get(boxIndex).contains(c)) {
                    return false;
                }
                
                rowSets.get(i).add(c);
                colSets.get(j).add(c);
                boxSets.get(boxIndex).add(c);
            }
        }
        
        return true;
    }
}