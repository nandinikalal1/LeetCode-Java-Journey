import java.util.Stack; 
public class validParenthesis {

    // Method that checks if the string of parentheses is valid
    public boolean isValid(String s) {

        // Step 1: Create a stack to store opening brackets
        Stack<Character> charStack = new Stack<>();

        // Step 2: Traverse the string character by character
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i); // Get current character

            // Step 3: Push all opening brackets into the stack
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                charStack.push(currChar);
            }

            // Step 4: When a closing bracket appears
            else if (currChar == ')' || currChar == '}' || currChar == ']') {

                // If stack is empty, that means no matching opening bracket
                if (charStack.isEmpty()) {
                    return false;
                }

                // Pop the top element from stack (latest opening bracket)
                char topChar = charStack.pop();

                // Check if the popped character and current character are a valid pair
                boolean notMatching =
                    (currChar == ')' && topChar != '(') ||
                    (currChar == '}' && topChar != '{') ||
                    (currChar == ']' && topChar != '[');

                if (notMatching) {
                    return false; // Found a mismatch
                }
            }
        }

        // Step 5: After processing, if the stack is empty, brackets were balanced
        return charStack.isEmpty();
    }

    // Step 6: Main method to test the code
    public static void main(String[] args) {
        validParenthesis solution = new validParenthesis(); 

        
        System.out.println(solution.isValid("()[]{}"));  
        System.out.println(solution.isValid("(]"));      
        System.out.println(solution.isValid("([{}])")); 
        System.out.println(solution.isValid("((("));     
    }
}
