
// Build a stack whose size is fixed

/*
Note -

If size is full then don't push any element & display a message "Stack OverFlow"
If size is '0' & we'r trying to do any operation other then push the display "Stack UnderFlow"
*/

class Build_Normal_Stack {

    int arr[];
    int index;

    // Constructor
    public Build_Normal_Stack(int size){ //  Initialize inside the constructor
       
        arr = new int[size];
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
           System.out.println("Stack OverFlow");
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
        Build_Normal_Stack b = new Build_Normal_Stack(3);
        b.push(10);
        b.push(20);
        b.push(30);
        b.display();
        System.out.println(b.pop());
        b.push(40);
        b.push(50);
        System.out.println(b.peek());
        System.out.println(b.pop());
        System.out.println(b.pop());
        System.out.println(b.pop());
        System.out.println(b.peek());
        System.out.println(b.pop());
        System.out.println(b.isEmpty());
        b.display();
    }  
}
