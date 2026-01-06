import java.util.Stack;
// This class stores a single price and its span value
class PriceSpan {
    int price;
    int span;
    // Constructor to set both price and span
    public PriceSpan(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class stockSpanner {
        // Stack to store previous prices and their spans
    private Stack<PriceSpan> stack;
        
    // Constructor - create an empty stack
    public stockSpanner() {
        stack = new Stack<>();
    }
       // This method takes a price and returns its stock span
    public int next(int price) {
         // Start span as 1 for current day
        int span = 1;
        // While stack is not empty and previous price is less or equal to current price
        // Add its span and remove that entry from stack
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
          // Push the current price and its calculated span into stack
        stack.push(new PriceSpan(price, span));
         // Return the span value for this price
        return span;
    }
}

// Example usage (optional test)
class Main {
    public static void main(String[] args) {
        stockSpanner s = new stockSpanner();
        System.out.println(s.next(100)); // 1
        System.out.println(s.next(80));  // 1
        System.out.println(s.next(60));  // 1
        System.out.println(s.next(70));  // 2
        System.out.println(s.next(60));  // 1
        System.out.println(s.next(75));  // 4
        System.out.println(s.next(85));  // 6
    }
}


