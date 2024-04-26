
// Validate Stack Sequences

import java.util.Stack;

class Validate_Stack_Sequences {

    public static boolean solve(int pushed[], int popped[]){

        Stack<Integer> st = new Stack<>();

        int j = 0; // 'j' for popped array

        for(int i=0; i<pushed.length; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
       return st.isEmpty(); 
    }

    public static void main(String[] args) {
        int pushed[] = {1,2,3,4,5};
        int popped[] = {4,3,5,1,2};
        System.out.println(solve(pushed, popped));
    }
    
}