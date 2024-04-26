
// Next Greater Element To Right (Circular)

/*
Input -> [3,8,1,4,2]
Output -> [8,-1,4,8,3]
*/

import java.util.Stack;

class Next_Greater_Right_Circular {

    public static int[] greater(int arr[]){

        int ans[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-2]); // Initially, we'll put 2nd last element in stack

        // Initially, we'll traverse the array from right (3rd last element)
        for(int i=arr.length-3; i>=0; i--){

            if(arr[i]>st.peek()){

                while(!st.isEmpty() && arr[i]>st.peek()){
                    st.pop();
                }
            }
          st.push(arr[i]);  
        }

        // Will traverse the array from right last element of the array
        for(int i=arr.length-1; i>=0; i--){

            if(arr[i]>=st.peek()){ // "Equal to" sign is required

                while(!st.isEmpty() && arr[i]>=st.peek()){
                    st.pop();
                }

                if(st.isEmpty())
                  ans[i] = -1;
            
                else
                  ans[i] = st.peek();
                    
                st.push(arr[i]);
            }

            else{
              ans[i] = st.peek();
              st.push(arr[i]);
            }
        }

       return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3,8,1,4,2};
        int ans[] = greater(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }  
    
}
