
// Design a Stack With Increment Operation

class Design_Stack_With_Increment_Operation {

    int arr[];
    int incrementvalue[];
    int i;

    // Constructor
    public Design_Stack_With_Increment_Operation(int maxSize) { // The size is given. So, we'll use array
    
      // // Initialize inside the constructor 
      arr = new int[maxSize];
      incrementvalue = new int[maxSize];
      i = -1;     
    }
    
    public void push(int x) {

        if(i+1<arr.length){ // The index on which I'm going to push, should exist  
            i++;
            arr[i] = x;
            incrementvalue[i] = 0;      
        }

        else{ // If size is full then return
            return;
        }
    }
    
    public int pop() {

       if(i == -1){  // Stack i.e array is empty then return -1
           return -1;
       }

        int x = arr[i];
        int increase = incrementvalue[i];
        i--; 

        // A/f decreasing 'i' check that stack's' size > 0. i.e index of array >= 0
        if(i>=0){
            incrementvalue[i] += increase; 
        }
       return x+increase; 
    }
    
    public void increment(int k, int val) {

        int index = Math.min(k-1, i); // 'k' is smaller or size of stack
        if(index>=0) // If stack i.e array isn't empty then 
          incrementvalue[index] += val;        
    }
    
    public static void main(String[] args) {
        Design_Stack_With_Increment_Operation st = new Design_Stack_With_Increment_Operation(3);
        st.push(1);
        st.push(2);
        System.out.println(st.pop());
        st.push(2);
        st.push(3);
        st.push(4);
        st.increment(2,100);
        st.increment(5,100);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}