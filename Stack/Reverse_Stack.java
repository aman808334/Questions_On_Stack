import java.util.Stack;

class Reverse_Stack {
    
    public static Stack<Integer> reverse(Stack<Integer> st){

        //Base Condition
        if(st.empty()){
            return st;

        }
        int n = st.peek();
        st.pop();
        reverse(st);
        insert(st, n);

        return st;
        
   
    }

    public static void insert(Stack<Integer> st, int element){

        // Base Condition
        if(st.empty()){
            st.push(element);
            return;
        }
    
        int n = st.peek();
        st.pop();
        insert(st, element);
        st.push(n);
       
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        

        System.out.println(reverse(st));
    }
}
