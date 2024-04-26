
// Next greater element to the right

/*
Input -> {2,5,9,1,3,12,6,8,7}
Output -> {5,9,12,12,12,-1,8,-1,-1}
*/

import java.util.Stack;

class Next_Greater_To_Right1 {

    public static int[] greater(int arr[]){

        int ans[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0); // While put 0th index in the stack

        // Will traverse the array from left and store the index in the stack
        for(int i=1; i<arr.length; i++){

            if(arr[i]>arr[st.peek()]){
                while(!st.empty() && arr[i]>arr[st.peek()]){
                    ans[st.peek()] = arr[i];
                    st.pop();
                }
                st.push(i);
            }

            else{
                st.push(i);
            }
        }

        for(int i=0; i<ans.length; i++){
            if(ans[i]==0)
              ans[i] = -1;
        }

       return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,9,1,3,12,6,8,7};
        int ans[] = greater(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }  
}
