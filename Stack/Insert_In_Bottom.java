import java.util.Stack;

class Insert_In_Bottom{

public static Stack<Integer> insert(Stack<Integer> st, int element){

    // Base Condition
    if(st.empty()){
        st.push(element);
        return st;
    }

    int n = st.peek();
    st.pop();
    insert(st, element);
    st.push(n);

   return st;
   
}

public static void main(String[] args) {

    Stack<Integer> st = new Stack<>();
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);
    st.push(50);

    int element = 60;
    System.out.println(insert(st, element));

}

}
