
// Celebrity Problem

/*
Celebrity is one who is known by everyone & who knows nobody

Input -

01111
10110
11011
00000
00010

Output -> 3 (Index of celebrity & if no one is celebrity then return -1)

Note - There can be only one celebrity (if celebrity exist)
*/

import java.util.Stack;

class Celebrity_Problem {

    public static int celebrity(int arr[][]){

        int totalperson = arr.length;
        Stack<Integer> st = new Stack<>();

        // Will put all the person in the stack
        for(int i=0; i<totalperson; i++)
          st.push(i);

        // Will take out 2 person from the stack & elimilate 1 & put other back in the stack
        while(st.size()!=1){
            int p1 = st.pop();
            int p2 = st.pop();

            if(arr[p1][p2]==0) // If p1 don't know p2 then p2 isn't a celebrity
             st.push(p1);
            else
             st.push(p2); // If p1 know p2 then p1 isn't a celebrity   
        }

        // At last one person will we in stack & he can be celebrity, if exist
        int candidate = st.peek();

        for(int i=0; i<arr.length; i++){
            if(i != candidate){
              if(arr[candidate][i] !=0 || arr[i][candidate] != 1){
                return -1;
              }
            }    
        }

      return candidate;
    }

    public static void main(String[] args) {
        
        int arr[][] = {{0,1,1,1,1},{1,0,1,1,0},{1,1,0,1,1},{0,0,0,0,0},{0,0,0,1,0}};
        System.out.println(celebrity(arr));
    } 
}
