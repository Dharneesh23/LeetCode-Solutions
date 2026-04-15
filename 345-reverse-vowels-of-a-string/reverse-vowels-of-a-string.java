class Solution {
    public String reverseVowels(String s) {
       char[] arr = s.toCharArray();
        
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            // move left pointer until vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            
            // move right pointer until vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            
            // swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
       
            return new String(arr);
    }
    
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    } 
    }
