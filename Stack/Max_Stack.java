
// Max Stack 

/*
Design a stack which has two extra features and that are - popMax() & peekMax()
*/

import java.util.Stack;

class Max_Stack {

   Stack<Integer> st;
   Stack<Integer> max;

    // Constructor
    public Max_Stack(){ // Initialize inside the constructor

      st = new Stack<>();
      max = new Stack<>();
    }

    public void push(int x){

      if(st.isEmpty())
         max.push(x);
      
      else{     
         int maximum = Math.max(max.peek(), x);
         max.push(maximum);
      }
      st.push(x);
    }

    public int pop(){
      max.pop();
      return st.pop(); 
    }

    public int peek(){
      return st.peek(); 
    }

    public int peekMax(){
      return max.peek(); 
    }

    public int popMax(){

      Stack<Integer> helper = new Stack<>();

      while(!st.isEmpty() && st.peek() != max.peek()){
         helper.push(st.pop());
         max.pop();
      }
      int maximum = st.pop(); // Will pop the maximum value of the stack
      max.pop();

      // We,ve to push elements in helper stack to the main stack
      while(!helper.isEmpty()){
         push(helper.pop()); // Call push function to push the value
      } 

      return maximum;  
    }

    public static void main(String[] args) {

      Max_Stack st = new Max_Stack();
      st.push(5);
      st.push(1);
      st.push(5);
      System.out.println(st.peek());
      st.push(3);
      System.out.println(st.popMax());
      System.out.println(st.peek());
      System.out.println(st.peekMax()); 
      System.out.println(st.popMax()); //
      System.out.println(st.pop());
      System.out.println(st.peekMax());
      System.out.println(st.pop());      
    }  
}
