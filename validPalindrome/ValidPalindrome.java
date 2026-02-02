package validPalindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s){ //method returns true if the string is valid palindrome
        //we will move both pointers inward to compare characters
        int left = 0; //Pointer starting from beginning of the string
        int right = s.length() - 1; //Pointer starting from the end of the string
        //Outer loop runs untill 2 pointers cross - to compare characters from both ends moving toward the center
        //if all the valid character pairs match, the string is a palindrome
        while(left<right){
            //Loop 1: Skip invalid characters on left - to ignore non alphanumeric characters.
            //If left is pointing to space comma or symbol - it should not be compared and we move forward until we find a valid letter or digit
            //After this loop, left will point to valid character or will cross right
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++; 
            }
            //Skip invalid characters on the right
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right --;//move right pointer backward
            }
                //Step 1: Compare valid characters. Convert both characters to lowercase. Case-insensitive check
                //Case insensitive, so A and a should be treated as equal
                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));

                //If characters donot match - string is not palindrome
                if(leftChar != rightChar){
                    return false;
                }
                //Step 2: Move inward after successful match
                //We have compared current pair, so we move closer to center to check next pair
                left ++;
                right --;
            }
            //If we exit loop without finding mismatch - it means all valid character pairs matched. Therefore string is valid palindrome
            return true;
        }
    
    public static void main(String[] args){
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); //true
        System.out.println(sol.isPalindrome("race a car"));
            System.out.println(sol.isPalindrome(""));
    }

}
