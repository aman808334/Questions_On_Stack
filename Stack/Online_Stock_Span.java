
// Online Stock Span

import java.util.Stack;

class Online_Stock_Span {

    class Pair{
    
        int value;
        int index;
    }

   Stack<Pair> st;
   int i = 0; // 'i' will give value to index

   // Constructor
    public Online_Stock_Span() {

        st = new Stack<>();

        /* We've to put 1st element in the stack but he can't do that b/c we don't know 1st element now.
        So, will put infinity & index -1 as pair in  the stack */
        Pair p = new Pair();
        p.value = 1000000; // Use power function or directly the number
        p.index = -1;
        st.push(p);

    }

    public int next(int price) {

        Pair p = new Pair();
        p.value = price;
        p.index = i;
        


        while(!st.isEmpty() && price>=st.peek().value){ // Stack won't be empty at any point of time. So empty condition isn't required
          st.pop();
        }

        int ans = i-st.peek().index;
        st.push(p);
        i++; // Increment index for next pair.

        return ans;                
    
    }

    public static void main(String[] args) {
        Online_Stock_Span a = new Online_Stock_Span();
        System.out.println(a.next(100));
        System.out.println(a.next(80));
        System.out.println(a.next(60));
        System.out.println(a.next(70));
        System.out.println(a.next(60));
        System.out.println(a.next(75));
        System.out.println(a.next(85));
    }
    
}