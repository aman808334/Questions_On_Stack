
// Build a stack whose size isn't fixed i.e like a behaviour of normal stack

class Build_Dynamic_Stack {

    int arr[];
    int index;

    // Constructor
    public Build_Dynamic_Stack(){ // The size is fixed. So, we'll use array
       
        arr = new int[3]; // Take a random size
        index = -1;
    }

    int size(){
      return index+1;
    }

    void display(){

        int currentsize = index+1;
        for(int i=0; i<currentsize; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void push(int x){

        if(index+1 == arr.length){ // Index on which we'r going to push isn't available
           
        int newarr[] = new int[2*arr.length]; // Make a new array of double size
        
        //Copy the data of previous array to new array
        for(int i=0; i<arr.length; i++){
            newarr[i] = arr[i];
        }

        arr = newarr; // Previousarray will point to new array
        index++;
        arr[index] = x;
        
        }

        else{
            index++;
            arr[index] = x;
        }

    }

    int pop(){
      if(index == -1){
         System.out.println("Stack UnderFlow");
         return -1;
      }
      else{

        int element = arr[index];
        index --;

        return element;
      }
    }

    int peek(){

    if(index == -1){
       System.out.println("Stack UnderFlow");
       return -1;
    }
    else
      return arr[index];   
    }

    boolean isEmpty(){
        return index == -1;  
      }

      public static void main(String[] args) {

        Build_Dynamic_Stack b = new Build_Dynamic_Stack();
        
        b.push(10);
        b.push(20);
        b.push(30);
        b.display();
        System.out.println(b.pop());
        b.push(40);
        b.push(50);
        b.push(60);
        System.out.println(b.peek());
        System.out.println(b.pop()); 
        System.out.println(b.pop());
        System.out.println(b.pop());
        System.out.println(b.peek());
        System.out.println(b.pop());
        System.out.println(b.isEmpty());
        b.display();
        System.out.println(b.pop());
        System.out.println(b.isEmpty());
        b.display();
      }  
}
